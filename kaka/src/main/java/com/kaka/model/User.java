package com.kaka.model;

import lombok.Data;

@Data
public class User {
    private String id;

    private String name;

    private String sex;

    public User(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

}