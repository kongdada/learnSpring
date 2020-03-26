package com.kaka.model;

import lombok.Data;

@Data
public class SuperUser extends User {
    private Long isVip;
    public SuperUser(String id){
        super(id);
    }
}
