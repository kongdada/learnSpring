package com.kaka.dao;

import com.alibaba.fastjson.JSON;
import com.kaka.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    public void test() {
//        System.out.println(getDayOfWeek("2019-1-3"));
//        testStringFormat();
        String str = getMonthDay("2019-01-07", ".");
        System.out.println(str);
    }

    /**
     * @param date
     * @param separator
     * @return
     */
    private String getMonthDay(String date, String separator) {
        return date.replaceAll("-", separator).substring(5);
    }

    /**
     * test StringFormat
     */
    public void testStringFormat() {
        String bussineTitle = "业务范围, 环比%1$svs%2$s差值, 环比%1$svs%2$s环比, 同比%1$svs%3$s差值, 同比%1$svs%2$s同比, %1$s大竞价消耗, %2$s大竞价消耗, %3$s大竞价消耗";
        System.out.println(String.format(bussineTitle, "2018-12-12", "2018-12-11", "2018-12-05"));

    }

    /**
     * @param dateStr
     * @return 获取输入日期是周几
     */
    private String getDayOfWeek(String dateStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        switch (week) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
        }
        return "获取DAY_OF_WEEK失败";
    }
}
