package com.guava3s.web.service;

import com.guava3s.bean.CarItemDO;
import com.guava3s.bean.OrderDetailDO;
import com.guava3s.bean.OrderItemDO;
import com.guava3s.common.Const;
import com.guava3s.encryption.DateSecurity;
import com.guava3s.api.mapper.OrderMapper;
import com.guava3s.api.service.CarService;
import com.guava3s.api.service.OrderService;
import com.guava3s.st.exception.NullCollectionException;
import com.guava3s.st.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName OrderServiceImpl
 * @date 2021/11/26 14:46
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CarService carService;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public String insertOrderItem(String uid) {
        List<CarItemDO> list = carService.listCarItem(uid);
        int count = carService.getCarItemCountFromCar(uid);
        double amount = carService.getTotalCarItemAmount(uid);

        // 获取时间戳
        Date date = new Date();
        String orderCode = date.getTime() + DateSecurity.aligningCode(uid);
        // 获取格式化时间
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        // 封装订单项POJO
        OrderItemDO orderItem = new OrderItemDO(null, orderCode, formatDate, count, amount, Const.ORDER_UNCONFIRMED, Integer.parseInt(uid));

        // 添加订单项到数据库表orderitemdo
        orderMapper.insertOrderItem(orderItem);

        // 生成订单详情集合
        List<OrderDetailDO> detailList = new ArrayList<>();
        for (CarItemDO carItem : list) {
            detailList.add(new OrderDetailDO(
                    null,
                    carItem.getCiTitle(),
                    carItem.getCiAmount(),
                    carItem.getCiPrice(),
                    carItem.getCiTotal(),
                    orderCode
            ));
        }
        // 批量添加订单详情到数据库表orderdetail
        orderMapper.batchInsertOrderItemDetail(detailList);

        // 删除购物车及购物项
        carService.removeAllCarItem(uid);

        return orderCode;
    }

    @Override
    public List<OrderItemDO> listOrderItemByUserId(String uid) {
        return orderMapper.listOrderItemAndOrderDetailByUserId(uid);
    }

    @Override
    public Page<OrderItemDO> listOrderItemByUserId(String uid, int pageNumber) throws NullCollectionException {
        return new Page<>(pageNumber, 4, orderMapper.listOrderItemAndOrderDetailByUserId(uid));
    }

    @Override
    public void removeOrderItem(String userId, String orderId) {
    }
}
