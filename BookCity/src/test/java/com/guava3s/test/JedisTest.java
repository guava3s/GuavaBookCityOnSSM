package com.guava3s.test;

import com.guava3s.common.Const;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author micolen
 * @version 1.0
 * @ClassName com.guava3s.test.JedisTest
 * @date 2021/12/3 16:17
 */
public class JedisTest {

    Jedis jedis = new Jedis("192.168.200.130", 6379);

    @Test
    public void test() {
        jedis.flushAll();
        int count = 500;
        for (int i = 0; i < count; i++) {
            insertCarItem1("1111", "10");
        }


    }

    public void insertCarItem1(String username, String bookId) {
        String keyCarItem = "User_" + username + "_CarItem_" + bookId;
        String keyCar = "User_" + username + "_Car";
        if (jedis.exists(keyCarItem)) {
            // 自增个数
            jedis.hincrBy(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_TOTAL, 1);
            String price = jedis.hget(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_PRICE);
            String total = jedis.hget(keyCarItem, Const.CAR_ITEM_ATTRIBUTE_TOTAL);
            // 处理精度问题

            BigDecimal amount = new BigDecimal(price).multiply(new BigDecimal(total));
            System.out.println("总金额为： " + amount.toString());
            jedis.hset(keyCarItem, "amount", amount.toString());

        } else {
            // 创建一个购物项缓存
            Map<String, String> map = new HashMap<>();
            map.put(Const.CAR_ITEM_ATTRIBUTE_TITLE, "测试书籍");
            map.put(Const.CAR_ITEM_ATTRIBUTE_PRICE, String.valueOf(BigDecimal.valueOf(64.333)));
            map.put(Const.CAR_ITEM_ATTRIBUTE_TOTAL, "1");
            map.put(Const.CAR_ITEM_ATTRIBUTE_AMOUNT, String.valueOf(BigDecimal.valueOf(64.333)));
            jedis.hmset(keyCarItem, map);
        }
        // 创建购物车
        jedis.sadd(keyCar, bookId);
    }
}
