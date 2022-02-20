package com.guava3s.web.interceptor;

import com.guava3s.exception.NullRangeException;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 范围检测拦截器
 *
 * @author micolen
 * @version 1.0
 * @ClassName ConditionMatchingInterceptor
 * @date 2021/12/3 19:26
 */
public class RangeDetectionInterceptor implements HandlerInterceptor {


    private static Logger logger = Logger.getLogger(RangeDetectionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws NullRangeException {
        logger.info("RangeDetectionInterceptor intercept 'books/*' request , execute preHandler method");
        // 获取当前购物车数量模块放在开头，确保异常处理器与BookController都能接收到
        HttpSession session = httpServletRequest.getSession();
        String min = httpServletRequest.getParameter("min");
        String max = httpServletRequest.getParameter("max");
        String path = httpServletRequest.getServletPath();
        session.setAttribute("pageNumber", path.substring(path.lastIndexOf("/") + 1));
        try {
            /*
            max与min皆为空：     抛出NullPointerException
            max与min长度皆为0    抛出NullRangeException
            max与min长度不为0    放行
             */
            if ((max.length() | min.length()) > 0) {
                logger.info("max的长度为 ：" + max.length());
                logger.info("min的长度为 ：" + min.length());
                return true;
            } else {
                throw new NullRangeException();
            }
        } catch (NullPointerException e) {
            throw new NullRangeException();
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
