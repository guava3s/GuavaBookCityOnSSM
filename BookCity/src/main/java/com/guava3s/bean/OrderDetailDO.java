package com.guava3s.bean;

import java.util.Objects;

/**
 * @author micolen
 * @version 1.0
 * @ClassName OrderDetailDO
 * @date 2021/12/2 17:53
 */
public class OrderDetailDO {

    private Integer odId;
    private String odTitle;
    private Double odAmount;
    private Double odPrice;
    private Integer odCount;
    private String oiIid;

    @Override
    public String toString() {
        return "OrderDetailDO{" +
                "odId=" + odId +
                ", odTitle='" + odTitle + '\'' +
                ", odAmount=" + odAmount +
                ", odPrice=" + odPrice +
                ", odCount=" + odCount +
                ", oiIid='" + oiIid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDetailDO that = (OrderDetailDO) o;
        return Objects.equals(odId, that.odId) &&
                Objects.equals(odTitle, that.odTitle) &&
                Objects.equals(odAmount, that.odAmount) &&
                Objects.equals(odPrice, that.odPrice) &&
                Objects.equals(odCount, that.odCount) &&
                Objects.equals(oiIid, that.oiIid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odId, odTitle, odAmount, odPrice, odCount, oiIid);
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getOdTitle() {
        return odTitle;
    }

    public void setOdTitle(String odTitle) {
        this.odTitle = odTitle;
    }

    public Double getOdAmount() {
        return odAmount;
    }

    public void setOdAmount(Double odAmount) {
        this.odAmount = odAmount;
    }

    public Double getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(Double odPrice) {
        this.odPrice = odPrice;
    }

    public Integer getOdCount() {
        return odCount;
    }

    public void setOdCount(Integer odCount) {
        this.odCount = odCount;
    }

    public String getOiIid() {
        return oiIid;
    }

    public void setOiIid(String oiIid) {
        this.oiIid = oiIid;
    }

    public OrderDetailDO() {
    }

    public OrderDetailDO(Integer odId, String odTitle, Double odAmount, Double odPrice, Integer odCount, String oiIid) {
        this.odId = odId;
        this.odTitle = odTitle;
        this.odAmount = odAmount;
        this.odPrice = odPrice;
        this.odCount = odCount;
        this.oiIid = oiIid;
    }
}
