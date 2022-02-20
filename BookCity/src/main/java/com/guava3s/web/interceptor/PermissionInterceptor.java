package com.guava3s.web.interceptor;

import com.guava3s.bean.UserDO;
import com.guava3s.common.Const;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限验证拦截器
 *
 * @author micolen
 * @version 1.0
 * @ClassName PermissionInterceptor
 * @date 2021/11/29 11:00
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        UserDO user = (UserDO) session.getAttribute(Const.DO_USER);
        if (user != null && user.getPermission().equals(Const.USER_PERMISSION_ROOT)) {
            return true;
        } else if (user != null) {
            return true;
        } else {
            // 转发视图
            httpServletRequest.setAttribute(Const.ERROR_MESSAGE, Const.TIP_MESSAGE_LOGIN);
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(httpServletRequest, httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
