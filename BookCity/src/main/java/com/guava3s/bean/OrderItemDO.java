package com.guava3s.bean;

import com.guava3s.common.Const;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 每个用户组成订单的订单项
 *
 * @author micolen
 * @version 1.0
 * @ClassName CartDO
 * @date 2021/11/26 14:10
 */
public class OrderItemDO {

    /**
     * 订单项id
     */
    private Integer oiId;

    /**
     * 订单id
     */
    private String oiIid;

    /**
     * 订单日期
     */
    private String oiDate;

    /**
     * 订单内商品个数
     */
    private Integer oiCount;

    /**
     * 该订单金额
     */
    private Double oiAmount;

    /**
     * 该订单状态
     */
    private String oiState;

    /**
     * 该订单所属用户
     */
    private Integer oiUser;

    /**
     * 订单是否可用；
     */
    private String oiUsable;

    /**
     * 订单详情
     */
    private List<OrderDetailDO> orderDetailList;


    public List<OrderDetailDO> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailDO> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getOiUsable() {
        return oiUsable;
    }

    public void setOiUsable(String oiUsable) {
        if (Const.NUMBER_0.equals(oiUsable)) {
            this.oiUsable = oiUsable;
        } else {
            this.oiUsable = Const.NUMBER_1;
        }
    }

    public OrderItemDO(Integer oiId, String oiIid, String oiDate, Integer oiCount, Double oiAmount, String oiState, Integer oiUser) {
        this.oiId = oiId;
        this.oiIid = oiIid;
        this.oiDate = oiDate;
        this.oiCount = oiCount;
        this.oiAmount = oiAmount;
        this.oiState = oiState;
        this.oiUser = oiUser;
    }

    public OrderItemDO(Integer oiId, String oiIid, String oiDate, Integer oiCount, Double oiAmount, String oiState, Integer oiUser, String oiUsable, List<OrderDetailDO> orderDetailList) {
        this.oiId = oiId;
        this.oiIid = oiIid;
        this.oiDate = oiDate;
        this.oiCount = oiCount;
        this.oiAmount = oiAmount;
        this.oiState = oiState;
        this.oiUser = oiUser;
        if (Const.NUMBER_0.equals(oiUsable)) {
            this.oiUsable = oiUsable;
        } else {
            this.oiUsable = Const.NUMBER_1;
        }
        this.orderDetailList = orderDetailList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItemDO that = (OrderItemDO) o;
        return Objects.equals(oiId, that.oiId) &&
                Objects.equals(oiIid, that.oiIid) &&
                Objects.equals(oiDate, that.oiDate) &&
                Objects.equals(oiCount, that.oiCount) &&
                Objects.equals(oiAmount, that.oiAmount) &&
                Objects.equals(oiState, that.oiState) &&
                Objects.equals(oiUser, that.oiUser) &&
                Objects.equals(oiUsable, that.oiUsable) &&
                Objects.equals(orderDetailList, that.orderDetailList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oiId, oiIid, oiDate, oiCount, oiAmount, oiState, oiUser, oiUsable, orderDetailList);
    }

    @Override
    public String toString() {
        return "OrderItemDO{" +
                "oiId=" + oiId +
                ", oiIid='" + oiIid + '\'' +
                ", oiDate=" + oiDate +
                ", oiCount=" + oiCount +
                ", oiAmount=" + oiAmount +
                ", oiState='" + oiState + '\'' +
                ", oiUser=" + oiUser +
                ", oiUsable='" + oiUsable + '\'' +
                ", orderDetailList=" + orderDetailList +
                '}';
    }

    public Integer getOiCount() {
        return oiCount;
    }

    public void setOiCount(Integer oiCount) {
        this.oiCount = oiCount;
    }

    public OrderItemDO() {
    }


    public String getOiIid() {
        return oiIid;
    }

    public void setOiIid(String oiIid) {
        this.oiIid = oiIid;
    }

    public Integer getOiUser() {
        return oiUser;
    }

    public void setOiUser(Integer oiUser) {
        this.oiUser = oiUser;
    }

    public Integer getOiId() {
        return oiId;
    }

    public void setOiId(Integer oiId) {
        this.oiId = oiId;
    }

    public String getOiDate() {
        return oiDate;
    }

    public void setOiDate(String oiDate) {
        this.oiDate = oiDate;
    }

    public Double getOiAmount() {
        return oiAmount;
    }

    public void setOiAmount(Double oiAmount) {
        this.oiAmount = oiAmount;
    }

    public String getOiState() {
        return oiState;
    }

    public void setOiState(String oiState) {
        this.oiState = oiState;
    }


}
