package com.kaka.dao;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

/**
 * @author konglinghui
 * @date 2018/12/28
 */

public class BeanutilsTest {
    private static void testCglibBeanCopier(OriginObject origin, int len) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println();
        System.out.println("================cglib BeanCopier执行" + len + "次================");
        DestinationObject destination3 = new DestinationObject();

        for (int i = 0; i < len; i++) {
            BeanCopier copier = BeanCopier.create(OriginObject.class, DestinationObject.class, false);
            copier.copy(origin, destination3, null);
        }
        stopWatch.stop();

        System.out.println("testCglibBeanCopier 耗时: " + stopWatch.getTaskCount());
    }

    private static void testApacheBeanUtils(OriginObject origin, int len)
            throws IllegalAccessException, InvocationTargetException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println();
        System.out.println("================apache BeanUtils执行" + len + "次================");
        DestinationObject destination2 = new DestinationObject();
        for (int i = 0; i < len; i++) {
            BeanUtils.copyProperties(destination2, origin);
        }
        stopWatch.stop();

        System.out.println("testApacheBeanUtils 耗时: " + stopWatch.getTotalTimeMillis());
    }

    private static void testSpringFramework(OriginObject origin, int len) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("================springframework执行" + len + "次================");
        DestinationObject destination = new DestinationObject();

        for (int i = 0; i < len; i++) {
            org.springframework.beans.BeanUtils.copyProperties(origin, destination);
        }
        stopWatch.stop();

        System.out.println("testSpringFramework 耗时: " + stopWatch.getTotalTimeMillis());
    }

    private static void testApacheBeanUtilsPropertyUtils(OriginObject origin, int len)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println();
        System.out.println("================apache BeanUtils PropertyUtils执行" + len + "次================");
        DestinationObject destination2 = new DestinationObject();
        for (int i = 0; i < len; i++) {
            PropertyUtils.copyProperties(destination2, origin);
        }

        stopWatch.stop();

        System.out.println("testApacheBeanUtilsPropertyUtils 耗时: " + stopWatch.getTaskCount());
    }

    public static void main(String[] args) {
        OriginObject origin = new OriginObject();
        try {
            BeanutilsTest.testApacheBeanUtils(origin, 50);
            BeanutilsTest.testSpringFramework(origin, 50);
            TimeUnit.SECONDS.sleep(2);
            BeanutilsTest.testApacheBeanUtils(origin, 100);
            BeanutilsTest.testSpringFramework(origin, 100);
            TimeUnit.SECONDS.sleep(2);
            BeanutilsTest.testApacheBeanUtils(origin, 1000);
            BeanutilsTest.testSpringFramework(origin, 1000);
            TimeUnit.SECONDS.sleep(2);
            BeanutilsTest.testApacheBeanUtils(origin, 10000);
            BeanutilsTest.testSpringFramework(origin, 10000);
            TimeUnit.SECONDS.sleep(2);
            BeanutilsTest.testApacheBeanUtils(origin, 100000);
            BeanutilsTest.testSpringFramework(origin, 100000);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("####################################################");
            BeanutilsTest.testApacheBeanUtils(origin, 100000);
            BeanutilsTest.testSpringFramework(origin, 100000);
            BeanutilsTest.testApacheBeanUtils(origin, 10000);
            BeanutilsTest.testSpringFramework(origin, 10000);
            BeanutilsTest.testApacheBeanUtils(origin, 1000);
            BeanutilsTest.testSpringFramework(origin, 1000);
            BeanutilsTest.testApacheBeanUtils(origin, 100);
            BeanutilsTest.testSpringFramework(origin, 100);
            BeanutilsTest.testApacheBeanUtils(origin, 50);
            BeanutilsTest.testSpringFramework(origin, 50);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
