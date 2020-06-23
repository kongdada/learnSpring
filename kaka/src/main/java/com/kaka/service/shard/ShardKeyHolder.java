package com.kaka.service.shard;

public class ShardKeyHolder {
    private static final ThreadLocal<ShardBean> HOLDER = new ThreadLocal<ShardBean>();

    public static ShardBean getShardBean() {
        return HOLDER.get();
    }

    public static void setShardBean(ShardBean shardBean) {
        HOLDER.set(shardBean);
    }

    public static void clearShardBean() {
        HOLDER.remove();
    }
}
