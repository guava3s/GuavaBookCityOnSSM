package com.guava3s.web.service;

import com.guava3s.bean.BookDO;
import com.guava3s.common.ServiceFilter;
import com.guava3s.api.mapper.BookMapper;
import com.guava3s.api.service.BookService;
import com.guava3s.st.pagehelper.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author micolen
 * @version 1.0
 * @ClassName BookServiceImpl
 * @date 2021/11/22 17:47
 */
@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insertBook(BookDO book) {
        BookDO bookByTitle = bookMapper.getBookByTitle(book.getTitle());
        if (bookByTitle == null) {
            bookMapper.insertBook(book);
        }
    }

    @Override
    public void insertBookAll(BookDO book) {
        bookMapper.insertBookAll(book);
    }

    @Override
    public void deleteBookById(String id) {

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteBookByTitle(String title) {
        Integer id = bookMapper.getBookByTitle(title).getId();
        bookMapper.deleteBookByTitle(title);
        logger.info("delete completion,begin order");
        bookMapper.flushOrder(++id);
    }

    @Override
    public BookDO getBookById(String id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public BookDO getBookByTitle(String title) {
        return bookMapper.getBookByTitle(title);
    }

    @Override
    public List<BookDO> listBooks() {
        return bookMapper.listBooks();
    }

    @Override
    public Page<BookDO> listBooksByIndexPageOf(String pageNumber) {
        return new Page<BookDO>(ServiceFilter.detectionIndex(pageNumber), 4, bookMapper.listBooks());
    }

    @Override
    public Page<BookDO> listBookByCondition(String pageNumber, String min, String max) {
        return new Page<BookDO>(ServiceFilter.detectionIndex(pageNumber), 4, bookMapper.listBookByCondition(min, max));
    }

    @Override
    public void updateBookInfo(BookDO book) {
        bookMapper.updateBookInfo(book);
    }

}
