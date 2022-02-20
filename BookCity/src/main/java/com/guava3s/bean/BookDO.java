package com.guava3s.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author micolen
 * @version 1.0
 * @ClassName Book
 * @date 2021/11/16 19:11
 */
public class BookDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 书名
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 价格
     */
    private double price;
    /**
     * 销量
     */
    private Integer sales;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 封面图片的路径
     */
    private String imgPath = "static/img/default.jpg";

    public BookDO() {
    }

    public BookDO(Integer id, String title, String author, double price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        BookDO book = (BookDO) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(sales, book.sales) &&
                Objects.equals(stock, book.stock) &&
                Objects.equals(imgPath, book.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, sales, stock, imgPath);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
