package com.guava3s.web.controller;

import com.guava3s.bean.BookDO;
import com.guava3s.common.Const;
import com.guava3s.api.service.BookService;
import com.guava3s.st.pagehelper.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author micolen
 * @version 1.0
 * @ClassName BookController
 * @date 2021/11/22 16:16
 */
@Controller
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * 查询所有图书信息
     *
     * @param model
     * @param pageNumber
     * @return
     */
    @RequestMapping(value = {"/books/{pageNumber}"})
    public String showBooks(Model model,
                            @PathVariable("pageNumber") String pageNumber,
                            @RequestParam(value = "max", required = false) String max,
                            @RequestParam(value = "min", required = false) String min) {
        logger.info("books的索引页码为: " + pageNumber);
        Page<BookDO> page = bookService.listBookByCondition(pageNumber, min, max);
        // 将搜索范围存放到session域中
        model.addAttribute("max", max);
        model.addAttribute("min", min);
        logger.info("获取页面信息为: " + page);
        model.addAttribute(Const.DO_PAGE, page);
        return "client/main2";
    }

    /**
     * 管理员访问
     * 通过页面索引获取该页包含的图书集合
     *
     * @return ModelAndView 对象
     */
    @RequestMapping(value = "/books/?/{pageIndex}", method = {RequestMethod.GET, RequestMethod.POST})
    public String getBooksByIndex(Model model,
                                  @PathVariable("pageIndex") String pageIndex) {
        Page<BookDO> page = bookService.listBooksByIndexPageOf(pageIndex);
        logger.info("The page content obtained is: " + page);
        model.addAttribute(Const.DO_PAGE, page);
        return "manager/book_manager";
    }

    /**
     * 管理员权限
     * 通过书名获取图书
     *
     * @param bookTitle 书名
     * @param model     request域共享数据
     * @return 目标图书对象
     */
    @GetMapping(value = "/book/{bookTitle}")
    public String getBookByTitle(Model model,
                                 @PathVariable String bookTitle) {
        BookDO book = bookService.getBookByTitle(bookTitle);
        model.addAttribute(Const.DO_BOOK, book);
        return "manager/book_update";
    }

    /**
     * 管理员权限
     * 添加一本图书
     *
     * @param bookDO 图书对象
     * @return 重定向视图
     */
    @RequestMapping(value = "/book", method = {RequestMethod.POST})
    public String addBook(BookDO bookDO) {
        bookService.insertBook(bookDO);
        return "redirect:/books/m/1";
    }

    /**
     * 管理员权限
     *
     * @return
     */
    @RequestMapping(value = "/book/{bookTitle}/delete")
    public String deleteBook(@PathVariable("bookTitle") String bookTitle) {
        logger.info("bookTitle is :" + bookTitle);
        bookService.deleteBookByTitle(bookTitle);
        return "redirect:/books/m/1";
    }

    /**
     * 管理员权限
     * 更新图书信息
     *
     * @param bookID id
     * @param book   最新book对象
     * @return 初始页面视图
     */
    @RequestMapping(value = "/book/{bookId}", method = {RequestMethod.PUT})
    public String updateBook(BookDO book,
                             @PathVariable("bookId") String bookID) {
        BookDO oldBook = bookService.getBookById(bookID);
        book.setId(Integer.parseInt(bookID));
        book.setImgPath(oldBook.getImgPath());
        bookService.updateBookInfo(book);
        return "redirect:/books/m/1";
    }


}
