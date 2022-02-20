package com.guava3s.api.mapper;

import com.guava3s.bean.BookDO;
import com.guava3s.bean.PageDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName BookMapper
 * @date 2021/11/22 17:55
 */
public interface BookMapper {

    /**
     * 通过图书名获取图书对象
     *
     * @param title 书名
     * @return 图书信息对象
     */
    BookDO getBookByTitle(String title);

    /**
     * 根据图书id获取图书对象
     *
     * @param id 图书id
     * @return
     */
    BookDO getBookById(String id);

    /**
     * 获取所有图书信息
     *
     * @return book list
     */
    List<BookDO> listBooks();

    /**
     * 使用分页查找图书集合
     *
     * @param index    目标索引
     * @param pageSize 显示条数
     * @return book list
     */
    List<BookDO> listBooksByLimit(@Param("index") Integer index, @Param("pageSize") Integer pageSize);


    /**
     * 通过条件+分页查询图书信息
     *
     * @param min      最小价格
     * @param max      最大价格
     * @param index    开始页面索引
     * @param pageSize 页面大小
     * @return
     */
    List<BookDO> listBookByConditionUseLimit(@Param("min") String min, @Param("max") String max,
                                             @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    /**
     * 使用模糊查询图书信息
     *
     * @param min 最小价格
     * @param max 最大价格
     * @return
     */
    List<BookDO> listBookByCondition(@Param("min") String min, @Param("max") String max);

    /**
     * 统计图书个数
     *
     * @return 图书总数
     */
    Integer countBooks();


    /**
     * 统计在某个区间内的个数
     *
     * @param min
     * @param max
     * @return
     */
    Integer countBookByBetween(@Param("min") String min, @Param("max") String max);

    /**
     * 更新图书信息
     *
     * @param bookDO 最新book对象
     */
    void updateBookInfo(BookDO bookDO);

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
     * 删除一本书
     *
     * @param title
     */
    void deleteBookByTitle(String title);

    /**
     * 刷新排序
     *
     * @param targetId 从哪个id开始刷新
     */
    void flushOrder(Integer targetId);
}
