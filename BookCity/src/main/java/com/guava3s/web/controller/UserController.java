package com.guava3s.web.controller;

import com.guava3s.bean.UserDO;
import com.guava3s.common.Const;
import com.guava3s.api.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;

/**
 * @author micolen
 * @version 1.0
 * @ClassName UserController
 * @date 2021/11/16 19:04
 */
@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 连接Redis服务器
     */
    @Autowired
    private Jedis jedis;

    /**
     * 使用Redis缓存服务器登录
     *
     * @param username 用户账号
     * @param pw       用户密码
     * @param session  session域对象
     * @return ModelAndView 对象
     */
    @RequestMapping(value = "/loginByRedis", method = RequestMethod.GET)
    public ModelAndView login1(
            @RequestParam String username,
            @RequestParam("password") String pw,
            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        /*
          缓存模块 line： 41-50
         */
        // 拼接字符
        StringBuffer key = new StringBuffer("user:" + username);
        System.out.println(key.toString());
        UserDO user;
        if (jedis.get(key.toString()) == null) {
            user = userService.login(username, pw);
            // 缓存User账户 设置过期时间为 60s
            jedis.setex(key.toString(), 60, user.getUsername());
        } else {
            user = userService.login(jedis.get(key.toString()), pw);
        }

        if (user != null) {
            session.setAttribute("User", user);
            modelAndView.setViewName("user/login_success");
        } else {
            // 返回提示信息
            modelAndView.addObject(Const.ERROR_MESSAGE, Const.ERROR_MESSAGE_VERIFY);
            modelAndView.setViewName("user/login");
        }
        return modelAndView;
    }

    /**
     * 使用普通模式登录
     *
     * @param session session域对象
     * @return ModelAndView 对象
     */
    @RequestMapping(value = "/users", method = {RequestMethod.POST})
    public ModelAndView login(String username, String password,
                              HttpSession session) {
        logger.info("Login success");
        ModelAndView mv = new ModelAndView();
        UserDO user = userService.login(username, password);
        logger.info(user);
        if (user != null) {
            session.setAttribute(Const.DO_USER, user);
            mv.setViewName("user/login_success");
        } else {
            // 返回提示信息
            mv.addObject(Const.ERROR_MESSAGE, Const.ERROR_MESSAGE_VERIFY);
            mv.setViewName("user/login");
        }
        return mv;
    }

    @PostMapping(value = "/user")
    public String register(UserDO user, Model model) {
        int count = userService.register(user);
        logger.info("返回的处理值为: " + count);
        if (count == 1) {
            return "user/regist_success";
        } else {
            model.addAttribute(Const.ERROR_MESSAGE, Const.TIP_MESSAGE_EXIST);
            return "user/regist";
        }
    }

    /**
     * 退出登录状态
     *
     * @param id      账号
     * @param session session域对象
     * @return 重定向视图
     */
    @RequestMapping(value = "/user/{username}")
    public String logout(@PathVariable("username") String id, HttpSession session) {
        userService.logout(id);
        logger.info("Successfully completion logout");
        if (session != null) {
            session.removeAttribute(Const.DO_USER);
            // 销毁session
            session.invalidate();
        }
        return "redirect:/index.jsp";
    }


}
