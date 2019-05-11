package com.water.kaka.controller;

import com.github.pagehelper.PageInfo;
import com.water.entity.User;
import com.water.kaka.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/exception")
    public String exceptionEg(int i) {
        int j = 1 / i;
        return "Hello World" + i;
    }

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/insert")
    public String insertData() {
        userService.createUser(10, "kong", 25);
        return "insertData";
    }

    @RequestMapping("/select")
    public String selectData() {

        return userService.findUserByName("kong").toString();
    }

    @RequestMapping("/findUserList")
    public PageInfo<User> findUserList() {
        return userService.findUserList(1, 10);
    }


}
