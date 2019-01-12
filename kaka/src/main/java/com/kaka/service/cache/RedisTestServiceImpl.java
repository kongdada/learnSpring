package com.kaka.service.cache;

/**
 * @author konglinghui
 * @date 2018/11/23
 */

import com.alibaba.fastjson.JSON;
import com.kaka.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisTestServiceImpl implements RedisTestService {
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUserById(String id) {
        String str = JSON.toJSONString(userMapper.selectByPrimaryKey(id)) ;
        return str;
    }

}
