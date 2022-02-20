package com.guava3s.web.controller;

import com.guava3s.bean.BookDO;
import com.guava3s.common.Const;
import com.guava3s.exception.NullCarItemException;
import com.guava3s.exception.NullRangeException;
import com.guava3s.api.service.BookService;
import com.guava3s.st.exception.NullCollectionException;
import com.guava3s.st.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


/**
 * 空目标处理器
 *
 * @author micolen
 * @version 1.0
 * @ClassName NullOrderExceptionHandler
 * @date 2021/12/18 14:39
 */
@ControllerAdvice
public class NullTargetExceptionHandler {

    @Autowired
    private BookService bookService;

    /**
     * 订单为空异常处理器
     *
     * @return 空订单页面
     */
    @ExceptionHandler(value = {NullCollectionException.class})
    public String nullOrderExceptionHandler() {
        return "error/nullOrder";
    }

    /**
     * 购物车为空异常处理器
     *
     * @return
     */
    @ExceptionHandler(value = {NullCarItemException.class})
    public String nullCarItemException() {
        return "error/nullCar";
    }

    /**
     * 查询范围为空异常
     *
     * @param model
     * @param session
     * @return
     */
    @ExceptionHandler(value = {NullRangeException.class})
    public String nullRangeException(Model model, HttpSession session) {
        String pageNumber = (String) session.getAttribute("pageNumber");
        Page<BookDO> page = bookService.listBooksByIndexPageOf(pageNumber);
        model.addAttribute(Const.DO_PAGE, page);
        return "client/main2";
    }


}
