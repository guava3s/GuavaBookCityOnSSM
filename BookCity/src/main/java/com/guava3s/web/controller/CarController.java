package com.guava3s.web.controller;

import com.guava3s.bean.CarItemDO;
import com.guava3s.bean.PageDO;
import com.guava3s.bean.UserDO;
import com.guava3s.common.Const;
import com.guava3s.exception.NullCarItemException;
import com.guava3s.api.service.BookService;
import com.guava3s.api.service.CarService;
import com.guava3s.api.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author micolen
 * @version 1.0
 * @ClassName CarController
 * @date 2021/11/26 14:58
 */
@Controller
public class CarController {

    private static Logger logger = Logger.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    /**
     * 保存一个订单项到Redis
     * redis中对Car的存储：User_账号_Car {购物项id1,2,3,4...}
     * 对CarItem的存储 ：User_账号_CarItem:购物项id
     * {
     * title ：
     * price：
     * total：
     * amount：
     * }
     *
     * @param bookId
     * @param session
     * @return
     */
    @RequestMapping(value = "/car/{bookId}", method = {RequestMethod.GET})
    public String addCarItemToRedis(HttpSession session, Model model,
                                    @PathVariable("bookId") String bookId,
                                    @RequestParam(value = "min", required = false) String min,
                                    @RequestParam(value = "max", required = false) String max) {
        String userId = ((UserDO) session.getAttribute(Const.DO_USER)).getUsername();
        carService.insertCarItem(userId, bookId);
        // 计算并返回购物车商品总数
        Integer bookCount;
        if (session.getAttribute(Const.CAR_ATTRIBUTE_COUNT) != null) {
            bookCount = (Integer) session.getAttribute(Const.CAR_ATTRIBUTE_COUNT);
        } else {
            bookCount = carService.getCarItemCountFromCar(userId);
        }
        bookCount++;
        logger.info("购物车中的数量为： " + bookCount);
        // 信息回显
        session.setAttribute(Const.CAR_ATTRIBUTE_COUNT, bookCount);
        session.setAttribute(Const.BOOK_NAME, bookService.getBookById(bookId).getTitle());
        // 跳转到原来页面
        String pageNumber = (String) session.getAttribute("pageNumber");
        return "redirect:/books/" + pageNumber + "?min=" + min + "&max=" + max;
    }

    /**
     * 从Redis中获取用户对应的CarItem
     *
     * @param userId 用户账户
     * @param model  模型数据
     * @return
     */
    @RequestMapping("/car/{userId}/{index}")
    public String getCarItemsFromRedisByUserId(Model model,
                                               @PathVariable("userId") String userId,
                                               @PathVariable(value = "index") String index) throws NullCarItemException {
        PageDO<CarItemDO> carItemPage = carService.listCarItemByLimit(userId, index);
        // 将购物项集合装载到购物项对象中并往request域赋值
        model.addAttribute(Const.DO_CAR_ITEMS_PAGE, carItemPage);
        return "cart/cart";
    }

    /**
     * 结账
     *
     * @param model  模型数据
     * @param userId 用户账号
     * @return 结账页面
     */
    @RequestMapping(value = "/cars/{userId}", method = {RequestMethod.GET})
    public String checkOut(Model model, @PathVariable String userId) {
        String orderNumber = orderService.insertOrderItem(userId);
        model.addAttribute("orderNumber", orderNumber);
        return "cart/checkout";
    }

    /**
     * 清空购物车
     *
     * @param userId 用户账号
     * @return
     */
    @RequestMapping(value = "/car/{userId}", method = {RequestMethod.DELETE})
    public String flushCar(@PathVariable("userId") String userId) {
        carService.removeAllCarItem(userId);
        return "cart/cart";
    }

}
