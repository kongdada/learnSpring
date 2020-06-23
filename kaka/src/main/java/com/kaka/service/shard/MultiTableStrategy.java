package com.kaka.service.shard;

import com.google.code.shardbatis.strategy.ShardStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


@Slf4j
public class MultiTableStrategy implements ShardStrategy {
    @Override
    public String getTargetTableName(String baseTableName, Object params, String mapperId) {

        // 实现分表策略时，拿出来shardBean，根据里面的参数，拼接出来具体的表名
        ShardBean shardBean = ShardKeyHolder.getShardBean();
        log.info("getTargetTableName: shardBean={}", shardBean);
        if (null == shardBean) {
            log.info("getTargetTableName: shardBean is null. then targetTableName={}", baseTableName);
            return baseTableName;
        }


        // 以下是正常的分表逻辑
        StringBuffer suffix = new StringBuffer("");
        String tbShardKey = shardBean.getTbShardKey();
        if (StringUtils.isNotBlank(tbShardKey)) {
            suffix.append(tbShardKey.trim());
        }

        String subShardKey = shardBean.getSubShardKey();
        if (StringUtils.isNotBlank(subShardKey)) {
            int num = subShardKey.hashCode() % 2;
            num = num < 0 ? -num : num;
            suffix.append(num);
        }

        if (StringUtils.isBlank(suffix)) {
            log.error("getTargetTableName: shardKey is blank.");
            throw new RuntimeException("SHARD_KEY IS BLANK");
        }

        StringBuffer shardTableName = new StringBuffer(baseTableName);
        shardTableName.append("_").append(suffix);
        log.debug("getTargetTableName: shardTableName={}", shardTableName);
        System.out.println("getTargetTableName: " + shardTableName.toString());
        return shardTableName.toString();
    }
}
