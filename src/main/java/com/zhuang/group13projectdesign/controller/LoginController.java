package com.zhuang.group13projectdesign.controller;

import com.zhuang.group13projectdesign.bean.User;
import com.zhuang.group13projectdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session,
                        HttpServletRequest request) {

        User user = userService.login(username);
        System.out.println(user.getId()+"      "+user.getUsername()+"       "+user.getPassword());

        if (user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "main";
        } else {
            map.put("msg", "用户名或密码错误！");
            return "login";
        }
    }
}
