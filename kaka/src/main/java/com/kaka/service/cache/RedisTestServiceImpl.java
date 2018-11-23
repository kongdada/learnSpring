package com.kaka.service.cache;

/**
 * @author konglinghui
 * @date 2018/11/23
 */

import org.springframework.stereotype.Service;

@Service
public class RedisTestServiceImpl implements RedisTestService {
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}
