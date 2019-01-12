package com.kaka.dao;

import lombok.Data;

/**
 * @author konglinghui
 * @date 2018/12/28
 */
@Data
public class DestinationObject {
    String name;
    int age;
    String sex;
    DestinationObject(){}
    DestinationObject(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
