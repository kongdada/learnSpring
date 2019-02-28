package com.kaka.dao;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.kaka.model.User;
import com.sun.deploy.util.StringUtils;
import commTool.DateTool;
import commTool.StringTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void test() {


        String str3 = "2015.0";
//        String[] s= str.split("/.");
//        System.out.println(str.substring(0, str.length()-1));

        System.out.println(DateTool.getTime());
        System.out.println(DateTool.getDayOfWeek("2019-02-28"));
        System.out.println(StringTool.getMonthDay("2019-02-28",""));
        StringTool.testStringFormat();
        StringTool.stringConcatByAnyting();


    }

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



}
