package com.guava3s.api.service;

import com.guava3s.bean.BookDO;
import com.guava3s.st.pagehelper.Page;

import java.util.List;


/**
 * @author micolen
 * @version 1.0
 * @ClassName BookService
 * @date 2021/11/22 17:42
 */
public interface BookService {


    /**
     * 通过图书id获取图书信息
     *
     * @param id
     * @return 图书信息对象
     */
    BookDO getBookById(String id);


    /**
     * 通过图书名获取图书对象
     *
     * @param title 书名
     * @return 图书信息对象
     */
    BookDO getBookByTitle(String title);

    /**
     * 获取所有图书信息
     *
     * @return 图书对象集合
     */
    List<BookDO> listBooks();

    /**
     * 通过页码获取目标页面内容
     *
     * @param pageNumber 页码
     * @return
     */
    Page<BookDO> listBooksByIndexPageOf(String pageNumber);

    /**
     * 通过条件查询图书信息
     *
     * @param pageNumber 目标页码
     * @param min        最小价格
     * @param max        最大价格
     * @return
     */
    Page<BookDO> listBookByCondition(String pageNumber, String min, String max);

    /**
     * 添加一本图书
     *
     * @param book
     */
    void insertBook(BookDO book);

    /**
     * 添加一本完整信息的书
     *
     * @param book
     */
    void insertBookAll(BookDO book);

    /**
     * 通过图书id删除图书
     *
     * @param id
     */
    void deleteBookById(String id);

    /**
     * 通过书名删除图书
     *
     * @param title 书名
     */
    void deleteBookByTitle(String title);


    /**
     * 更新图书信息
     *
     * @param book 最新book对象
     */
    void updateBookInfo(BookDO book);


}
