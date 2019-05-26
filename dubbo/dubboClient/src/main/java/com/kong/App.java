package com.kong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoApiService demoApiService = context.getBean(DemoApiService.class);
        String result = demoApiService.getUser(1l);
        System.out.println("result:" + result);
        System.out.println(demoApiService.getUser(2l));
        System.out.println(demoApiService.getUser(3l));
    }
}
