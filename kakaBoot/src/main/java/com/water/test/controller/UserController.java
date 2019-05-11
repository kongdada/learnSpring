package com.water.test.controller;

import com.github.pagehelper.PageInfo;
import com.water.entity.User;
import com.water.test.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private MemberServiceImpl memberService;

    @RequestMapping("/testUserList")
    public PageInfo<User> findUserList() {
        return memberService.findMemberList(1, 10);
    }

    @RequestMapping("/tesInsert")
    public String insertData() {
        memberService.insertMember(11, "kong", 26);
        return "insertData";
    }
}
