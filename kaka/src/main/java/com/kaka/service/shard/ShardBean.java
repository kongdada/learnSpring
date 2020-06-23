package com.kaka.service.shard;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ShardBean implements Serializable {
    private String dsShardKey;
    private String tbShardKey;
    private String subShardKey;
    private String tableName;

    public ShardBean(String dsShardKey, String tbShardKey, String subShardKey, String tableName) {
        this.dsShardKey = dsShardKey;
        this.tbShardKey = tbShardKey;
        this.subShardKey = subShardKey;
        this.tableName = tableName;
    }

    public ShardBean(String tableName) {
        this.tableName = tableName;
    }
}
