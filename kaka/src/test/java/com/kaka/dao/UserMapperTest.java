package com.kaka.dao;

import com.kaka.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        int id = 1;
        User user = userMapper.selectByPrimaryKey(String.valueOf(id));
        System.out.println(user.toString());
    }

    @Test
    public void selectBySex() {
        String sex = "男";
        List<User> list = userMapper.selectBySex(sex);
        System.out.println("********* result:" + list.toString());
    }
}
