package com.guava3s.bean;

import java.util.List;
import java.util.Objects;

/**
 * @author micolen
 * @version 1.0
 * @ClassName PageDO
 * @date 2021/11/22 19:21
 */
public class PageDO<T> {

    /**
     * 当前页总金额
     */
    private double amount;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总条数(在数据库中的行数)
     */
    private int totalRecode;

    /**
     * 总项数
     */
    private int totalItems;

    /**
     * 每页显示的条数
     */
    private static final Integer PAGE_SIZE = 4;

    /**
     * 携带的项目集合
     */
    private List<T> bookList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    @Override
    public String toString() {
        return "PageDO{" +
                "amount=" + amount +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalRecode=" + totalRecode +
                ", totalItems=" + totalItems +
                ", bookList=" + bookList +
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
        PageDO<?> pageDO = (PageDO<?>) o;
        return Double.compare(pageDO.amount, amount) == 0 &&
                currentPage == pageDO.currentPage &&
                totalPage == pageDO.totalPage &&
                totalRecode == pageDO.totalRecode &&
                totalItems == pageDO.totalItems &&
                Objects.equals(bookList, pageDO.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currentPage, totalPage, totalRecode, totalItems, bookList);
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * 通过总条数计算总页数
     *
     * @param totalRecode 总条数
     */
    public void setTotalPage(int totalRecode) {
        if (totalRecode > 0) {
            this.totalPage = (totalRecode % PAGE_SIZE) == 0 ? totalRecode / PAGE_SIZE : (totalRecode / PAGE_SIZE) + 1;
        } else {
            this.totalPage = 1;
        }
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public List<T> getBookList() {
        return bookList;
    }

    public void setBookList(List<T> bookList) {
        this.bookList = bookList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PageDO() {
    }

    public PageDO(int currentPage, int totalPage, int totalRecode, List<T> bookList) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalRecode = totalRecode;
        this.bookList = bookList;
    }

    public PageDO(double amount, int currentPage, int totalPage, int totalRecode, int totalItems, List<T> bookList) {
        this.amount = amount;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalRecode = totalRecode;
        this.totalItems = totalItems;
        this.bookList = bookList;
    }
}
