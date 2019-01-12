package com.kaka.service.cache;

/**
 * @author konglinghui
 * @date 2018/11/23
 */

public interface RedisTestService {
    public String getTimestamp(String param);
    public String getUserById(String id);
}
