package com.kaka.dao;

import com.alibaba.fastjson.JSON;
import com.kaka.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        int id = 1;
        User user = userMapper.selectByPrimaryKey(String.valueOf(id));
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void selectBySex() {
        String sex = "";
        String name = "zhang";
        List<User> list = userMapper.selectBySex(name, sex);
        System.out.println("********* result:" + list.toString());
    }
    @Test
    public void test(){
        Long time = System.currentTimeMillis();
        System.out.println(String.valueOf(time));
    }
}
