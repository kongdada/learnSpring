package com.water.test.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.water.entity.User;
import com.water.test.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public PageInfo<User> findMemberList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<User> listUser = memberMapper.findMemberList();
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
        return pageInfoUser;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMember(Integer id, String name, Integer age) {
        jdbcTemplate.update("insert into user values(?,?,?);", id, name, age);
    }

}

