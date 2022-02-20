package com.guava3s.web.controller;

import com.guava3s.bean.UserDO;
import com.guava3s.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author micolen
 * @version 1.0
 * @ClassName TestController
 * @date 2021/11/22 12:18
 */
@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "p1",required = false,defaultValue = "1") String p1,
                       String p2, HttpSession session) {
        UserDO user = userService.login(p1, p2);
        System.out.println(user);
        session.setAttribute("User", user);
        return "success";
    }

    @RequestMapping("/test/{username}/{password}")
    public ModelAndView test(@PathVariable("username") String p1, @PathVariable("password") String p2) {
        UserDO user = userService.login(p1, p2);
        System.out.println(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("User", user);
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello world");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "test ResponseBody successfully";
    }


    @RequestMapping("/testJson")
    @ResponseBody
    public UserDO testJson() {
        return new UserDO(1, "Micolen", "123456", null, null, null);
    }


}
