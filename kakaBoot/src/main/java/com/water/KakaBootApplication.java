package com.water;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 等同于 @EnableAutoConfiguration + @ComponentScan("com.Water.kakaBoot.Controller")
 */
@SpringBootApplication
//@MapperScan(basePackages = {"com.water.kaka.mapper", "com.water.test.mapper"})
public class KakaBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaBootApplication.class, args);
    }

}
