package com.kaka.dao;

import com.alibaba.fastjson.JSON;
import com.kaka.model.User;
import commTool.NumTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserMapperTest {
    private final static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        logger.debug("logback 成功了");
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
    public void test() {
//        System.out.println(DateTool.getTime());
//        System.out.println(DateTool.getDayOfWeek("2019-02-28"));
//        System.out.println(StringTool.getMonthDay("2019-02-28",""));
//        StringTool.testStringFormat();
//        StringTool.stringConcatByAnyting();
//        StringTool.spiltStringByBank();
//        StringTool.spiltStringByPoint();
//        DateTool.getTimeRange();
        NumTool.autoAdd();
    }

    @Test
    public void TestLongSubInteger() {
        Long CurrentBigCpcCost = 74925604L;
        Long YestBigCpcCost = 80014531L;
        Integer waveThresholdValue = 121832700;
        long temp = Math.abs(CurrentBigCpcCost - YestBigCpcCost);
        Integer tempb = waveThresholdValue * 100;
        if (temp < tempb) {
            System.out.println("################ GOOD JOB ###########");
        } else {
            System.out.println("################ FUCK JOB ###########");
        }
    }

    @Test
    public void test1() {
        Long a = 967306074781305167L;
        Integer b = a.intValue();

        System.out.println(b);
//        System.out.println(c);
    }


}
