package com.guava3s.api.service;

import com.guava3s.bean.OrderItemDO;
import com.guava3s.st.pagehelper.Page;

import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName OrderService
 * @date 2021/11/26 14:46
 */
public interface OrderService {

    /**
     * 添加一个订单项
     *
     * @param uid 用户账号
     * @return 返回一个订单号
     */
    String insertOrderItem(String uid);

    /**
     * 通过用户账号获取该用户的所有订单
     *
     * @param uid 用户账号
     * @return
     */
    List<OrderItemDO> listOrderItemByUserId(String uid);

    /**
     * 通过用户账号以及目标起始页面获取该用户的所有的订单
     *
     * @param uid   用户账号
     * @param pageNumber 起始页码
     * @return
     */
    Page<OrderItemDO> listOrderItemByUserId(String uid, int pageNumber);

    /**
     * 删除一个订单项
     *
     * @param userId
     * @param orderId
     */
    void removeOrderItem(String userId, String orderId);
}
