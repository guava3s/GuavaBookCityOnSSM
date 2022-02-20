package com.guava3s.bean;

import java.util.Objects;

/**
 * @author micolen
 * @version 1.0
 * @ClassName CarItem
 * @date 2021/11/26 14:40
 */
public class CarItemDO {


    /**
     * 该商品名
     */
    private String ciTitle;

    /**
     * 该商品个数
     */
    private Integer ciTotal;

    /**
     * 该商品单价
     */
    private Double ciPrice;

    /**
     * 该商品总价
     */
    private Double ciAmount;




    public CarItemDO() {
    }

    public CarItemDO(String ciTitle, Integer ciTotal, Double ciPrice, Double ciAmount) {
        this.ciTitle = ciTitle;
        this.ciTotal = ciTotal;
        this.ciPrice = ciPrice;
        this.ciAmount = ciAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarItemDO carItemDO = (CarItemDO) o;
        return Objects.equals(ciTitle, carItemDO.ciTitle) &&
                Objects.equals(ciTotal, carItemDO.ciTotal) &&
                Objects.equals(ciPrice, carItemDO.ciPrice) &&
                Objects.equals(ciAmount, carItemDO.ciAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciTitle, ciTotal, ciPrice, ciAmount);
    }


    public String getCiTitle() {
        return ciTitle;
    }

    public void setCiTitle(String ciTitle) {
        this.ciTitle = ciTitle;
    }

    public Integer getCiTotal() {
        return ciTotal;
    }

    public void setCiTotal(Integer ciTotal) {
        this.ciTotal = ciTotal;
    }

    public Double getCiPrice() {
        return ciPrice;
    }

    public void setCiPrice(Double ciPrice) {
        this.ciPrice = ciPrice;
    }

    public Double getCiAmount() {
        return ciAmount;
    }

    public void setCiAmount(Double ciAmount) {
        this.ciAmount = ciAmount;
    }

    @Override
    public String toString() {
        return "CarItemDO{" +
                "ciTitle='" + ciTitle + '\'' +
                ", ciTotal=" + ciTotal +
                ", ciPrice=" + ciPrice +
                ", ciAmount=" + ciAmount +
                '}';
    }

}
