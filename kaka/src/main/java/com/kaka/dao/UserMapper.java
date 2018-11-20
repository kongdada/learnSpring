package com.kaka.dao;

import com.kaka.model.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    List<User> selectBySex(String sex);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}