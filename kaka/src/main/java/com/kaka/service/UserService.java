package com.kaka.service;

import com.alibaba.fastjson.JSON;
import com.kaka.dao.UserMapper;
import com.kaka.model.User;
import com.kaka.service.shard.ShardBean;
import com.kaka.service.shard.ShardEnabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateUserById(String id) {
        return userMapper.updateByPrimaryKey(new User(id, "kong", "男"));
    }

    @ShardEnabled
    public int createUser(ShardBean shardBean, User user) {
        System.out.println("createUser shardBean: "+ JSON.toJSONString(shardBean));
        return userMapper.insert(user);
    }
}