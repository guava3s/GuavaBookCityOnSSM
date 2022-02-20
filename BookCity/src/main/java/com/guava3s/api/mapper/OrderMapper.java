package com.guava3s.api.mapper;

import com.guava3s.bean.OrderDetailDO;
import com.guava3s.bean.OrderItemDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName OrderMapper
 * @date 2021/11/26 14:45
 */
public interface OrderMapper {

    /**
     * 添加一项订单
     *
     * @param orderItem
     */
    void insertOrderItem(OrderItemDO orderItem);

    /**
     * 批量添加
     *
     * @param detailList
     */
    void batchInsertOrderItemDetail(List<OrderDetailDO> detailList);

    /**
     * 通过用户账号获取该用户的所有订单
     *
     * @param uid 用户账号
     * @return 订单项集合
     */
    List<OrderItemDO> listOrderItemByUserId(String uid);

    /**
     * 通过订单号获取订单详情表的所有详情项
     *
     * @param oiIid 用户账号
     * @return 订单详情项集合
     */
    List<OrderDetailDO> listOrderDetailByOiIid(String oiIid);

    /**
     * 通过用户账号获取该用户所有的订单项以及订单项对应的订单详情项
     *
     * @param uid 用户账号
     * @return 完整订单项集合
     */
    List<OrderItemDO> listOrderItemAndOrderDetailByUserId(String uid);

    /**
     * 通过订单号移除该订单
     *
     * @param userId 用户账号
     * @param oiIid  订单号
     */
    void removeOrderItemByOiIid(@Param("userId") String userId, @Param("oiIid") String oiIid);


}
