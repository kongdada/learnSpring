package com.kaka.cache;

import com.alibaba.fastjson.JSON;
import com.kaka.dao.UserMapper;
import com.kaka.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author konglinghui
 * @date 2018/11/22
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MybatisCacheTest {
    private static final Logger logger = LoggerFactory.getLogger(MybatisCacheTest.class);
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testCache2() {
        int id = 1;
        User user = userMapper.selectByPrimaryKey(String.valueOf(id));
        System.out.println(JSON.toJSONString(user));
    }

}