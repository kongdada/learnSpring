package com.kaka.controller;

import com.kaka.model.User;
import com.kaka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public ModelAndView getUser(String id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/getUser");
        return modelAndView;
    }

    // http://localhost:8080/kaka/user/getUser.do?id=3


    // http://localhost:8080/kaka/user/rest/user.do?id=3
    @RequestMapping("rest/user")
    @ResponseBody
    public void getUserById(@RequestParam Map<String, Object> body) {
        System.out.println("FUCK!!!");
        System.out.println("body" + body);
    }

}