package com.kaka.service.shard;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSourceStrategy extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        ShardBean shardBean = ShardKeyHolder.getShardBean();
        if(null != shardBean){
            return shardBean.getDsShardKey();
        }
        return null;
    }
}
