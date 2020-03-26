package com.kaka.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    protected BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    protected Long id;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 最后修改时间
     */
    protected Date updateTime;
}
