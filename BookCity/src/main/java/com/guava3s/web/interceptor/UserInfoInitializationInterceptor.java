package com.guava3s.web.interceptor;

import com.guava3s.bean.UserDO;
import com.guava3s.common.Const;
import com.guava3s.api.service.CarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户信息初始化拦截器
 *
 * @author micolen
 * @version 1.0
 * @ClassName UserInitializationDataInterceptor
 * @date 2021/12/19 14:41
 */
public class UserInfoInitializationInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(UserInfoInitializationInterceptor.class);

    @Autowired
    private CarService carService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        UserDO user = (UserDO) session.getAttribute(Const.DO_USER);
        logger.info("The UserDO object in the current Session scope is  " + user);
        if (user != null) {
            int bookCount = carService.getCarItemCountFromCar(user.getUsername());
            session.setAttribute(Const.CAR_ATTRIBUTE_COUNT, bookCount);
            logger.info("bookCount value is ：" + bookCount);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
