package com.kaka.model;

import lombok.Data;

import java.util.Date;

@Data
public class ComponentRecordEntity  extends BaseEntity{
    public ComponentRecordEntity() {
        super();
    }

    public ComponentRecordEntity(Long id) {
        super(id);
    }

    /**
     * 58id
     */
    private Long wbId;

    /**
     * 数据类型
     */
    private Integer type;

    /**
     * 组件信息内容
     */
    private String content;

    /**
     * 组件完成时间
     */
    private Date finishTime;
}
