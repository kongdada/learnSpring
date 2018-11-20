package com.kaka.service;

import com.kaka.dao.UserMapper;
import com.kaka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
    }
}