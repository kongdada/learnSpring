package com.kaka.controller;

import com.kaka.model.User;
import com.kaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public ModelAndView getUser(String id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/getUser");
        return modelAndView;
    }
}