package com.guava3s.web.service;

import com.guava3s.bean.BookDO;
import com.guava3s.bean.CarItemDO;
import com.guava3s.bean.PageDO;
import com.guava3s.common.Const;
import com.guava3s.exception.NullCarItemException;
import com.guava3s.api.service.BookService;
import com.guava3s.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author micolen
 * @version 1.0
 * @ClassName CarServiceImpl
 * @date 2021/11/26 14:46
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private BookService bookService;

    @Autowired
    private Jedis jedis;

    /**
     * @param uid   用户账号
     * @param index 当前页数索引 - 此时index参数为环绕通知更改后的参数
     * @return
     * @throws NullCarItemException
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public PageDO<CarItemDO> listCarItemByLimit(String uid, String index) throws NullCarItemException {
        // 转换String类型为Integer类型
        Integer newIndex = Integer.parseInt(index);
        long beginIndex = (newIndex - 1) * 4;

        String keyCar = new StringBuffer("User_").append(uid).append("_Car").toString();
        Set<String> car = jedis.smembers(keyCar);
        if (car == null || car.isEmpty()) {
            throw new NullCarItemException();
        }
        String keyCarCopy = new StringBuffer(keyCar).append("_Copy").toString();
        jedis.del(keyCarCopy);
        // 伪备份
        for (String item : car) {
            jedis.lpush(keyCarCopy, item);
        }
        PageDO<CarItemDO> carPage = new PageDO<CarItemDO>();
        // 分页查找
        List<String> carItems = jedis.lrange(keyCarCopy, beginIndex, beginIndex + 3);
        List<CarItemDO> carItemList = this.listCarItem(carItems, uid);
        // 本页内容集合
        carPage.setBookList(carItemList);
        // 设置当前页数
        carPage.setCurrentPage(newIndex);
        // 总条数
        carPage.setTotalRecode(this.getCarItemCountFromCar(uid));
        // 总项数
        carPage.setTotalItems((int) ((long) jedis.scard(keyCar)));
        // 总页数
        carPage.setTotalPage(carPage.getTotalItems());
        // 设置总金额
        carPage.setAmount(this.getTotalCarItemAmount(uid));
        return carPage;
    }

    @Override
    public List<CarItemDO> listCarItem(String uid) {
        String keyCar = "User_" + uid + "_Car";
        Set<String> smembers = jedis.smembers(keyCar);
        return this.listCarItem(smembers, uid);
    }


    @Override
    public void removeAllCarItem(String username) {
        // 先删购物项，再删购物车，再删备份购物车
        String keyCar = "User_" + username + "_Car";
        String keyCarCopy = keyCar + "_Copy";
        List<String> items = jedis.lrange(keyCarCopy, 0, -1);
        for (String item : items) {
            jedis.del("User_" + username + "_CarItem_" + item);
        }
        jedis.del(keyCar);
        jedis.del(keyCarCopy);
    }

    @Override
    public int getCarItemCountFromCar(String username) {
        return (int) this.sumColumn(username, Const.CAR_ITEM_ATTRIBUTE_TOTAL);
    }

    @Override
    public double getTotalCarItemAmount(String username) {
        return this.sumColumn(username, Const.CAR_ITEM_ATTRIBUTE_AMOUNT);
    }

    /**
     * 添加一个购物项，并在Redis中创建一个购物车
     */
    @Override
    public void insertCarItem(String username, String bookId) {
        BookDO book = bookService.getBookById(bookId);
        String keyCarItem = "User_" + username + "_CarItem_" + bookId;
        String keyCar = "User_" + username + "_Car";
        if (jedis.exists(keyCarItem)) {
            // 自增个数
            jedis.hincrBy(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_TOTAL, 1);
            String price = jedis.hget(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_PRICE);
            String total = jedis.hget(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_TOTAL);
            // 处理精度问题
            BigDecimal amount = new BigDecimal(price).multiply(new BigDecimal(total));
            jedis.hset(keyCarItem, "amount", amount.toString());

        } else {
            // 创建一个购物项缓存
            Map<String, String> map = new HashMap<>();
            map.put(Const.CAR_ITEM_ATTRIBUTE_TITLE, book.getTitle());
            map.put(Const.CAR_ITEM_ATTRIBUTE_PRICE, String.valueOf(BigDecimal.valueOf(book.getPrice())));
            map.put(Const.CAR_ITEM_ATTRIBUTE_TOTAL, "1");
            map.put(Const.CAR_ITEM_ATTRIBUTE_AMOUNT, String.valueOf(BigDecimal.valueOf(book.getPrice())));
            jedis.hmset(keyCarItem, map);
        }
        // 创建购物车
        jedis.sadd(keyCar, bookId);
    }

    /**
     * 计算所有购物项中某一列的求和
     *
     * @param username        用户账号
     * @param calculateTarget 计算目标
     * @return 计算总和
     */
    private double sumColumn(String username, String calculateTarget) {
        String keyCar = "User_" + username + "_Car";
        String keyCarItem;
        // 计算copy购物车的内容
        Set<String> items = jedis.smembers(keyCar);
        BigDecimal count = new BigDecimal(0);
        for (String bookId : items) {
            keyCarItem = "User_" + username + "_CarItem_" + bookId;
            String total = jedis.hget(keyCarItem, calculateTarget);
            // 使用BigDecimal解决精度问题
            count = count.add(new BigDecimal(total));
        }
        return count.doubleValue();
    }

    /**
     * 将目标集合中的数据提取，并获取在Redis中的存在key
     *
     * @param smembers
     * @param uid
     * @return
     */
    private List<CarItemDO> listCarItem(Collection<String> smembers, String uid) {
        ArrayList<CarItemDO> carItemList = new ArrayList<>();
        for (String member : smembers) {
            String keyCarItem = "User_" + uid + "_CarItem_" + member;
            Map<String, String> carItem = jedis.hgetAll(keyCarItem);
            carItemList.add(
                    // 添加一项购物项
                    new CarItemDO(
                            carItem.get(Const.CAR_ITEM_ATTRIBUTE_TITLE),
                            Integer.parseInt(carItem.get(Const.CAR_ITEM_ATTRIBUTE_TOTAL)),
                            new BigDecimal(carItem.get(Const.CAR_ITEM_ATTRIBUTE_PRICE)).doubleValue(),
                            new BigDecimal(carItem.get(Const.CAR_ITEM_ATTRIBUTE_AMOUNT)).doubleValue())
            );
        }
        return carItemList;
    }

}
