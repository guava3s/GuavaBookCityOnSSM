package com.guava3s.web.controller;

import com.guava3s.bean.OrderItemDO;
import com.guava3s.bean.UserDO;
import com.guava3s.common.Const;
import com.guava3s.api.service.OrderService;
import com.guava3s.st.exception.NullCollectionException;
import com.guava3s.st.pagehelper.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author micolen
 * @version 1.0
 * @ClassName OrderController
 * @date 2021/12/2 10:54
 */
@Controller
public class OrderController {

    private static Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{pageNumber}")
    public String getOrderItemsUsePage(Model model, HttpSession session,
                                       @PathVariable("pageNumber") String pageNumber) throws NullCollectionException {
        UserDO user = (UserDO) session.getAttribute(Const.DO_USER);
        logger.info("当前用户为： " + user);
        logger.info("目标页码为：" + pageNumber);
        Page<OrderItemDO> page = orderService.listOrderItemByUserId(user.getUsername(), Integer.parseInt(pageNumber));

        logger.info("获取的页面信息为：" + page);
        logger.debug("显示信息为： " + page.getDisplayList());
        model.addAttribute("Page", page);
        return "order/order";
    }

    public String showOrderDetail() {


        return null;
    }

}
