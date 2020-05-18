package com.zhuang.group13projectdesign.controller;

import com.zhuang.group13projectdesign.bean.User;
import com.zhuang.group13projectdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUserInfo/{id}")
    public String getUserInfo(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("userInfo", user);
        return "ownInfo";
    }
}
