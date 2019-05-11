package com.water.kaka.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.water.entity.User;
import com.water.kaka.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(Integer id, String name, Integer age) {
        jdbcTemplate.update("insert into user values(?,?,?);", id, name, age);
    }

    @Autowired
    private UserMapper userMapper;

    public List<User> findUserByName(String name) {
        return userMapper.findByName(name);
    }

    public PageInfo<User> findUserList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<User> listUser = userMapper.findUserList();
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
        return pageInfoUser;
    }

}

