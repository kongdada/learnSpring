package com.kaka.cache;

/**
 * @author konglinghui
 * @date 2018/11/23
 */

import com.kaka.service.UserService;
import com.kaka.service.cache.RedisTestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTestServiceTest extends SpringTestCase {

    @Autowired
    private RedisTestService redisTestService;
    @Autowired
    private UserService userService;

    @Test
    public void getTimestampTest() throws InterruptedException {
/*        System.out.println("第一次调用：" + redisTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + redisTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + redisTestService.getTimestamp("param"));*/

        System.out.println("第一次调用：" + redisTestService.getUserById("1"));
        userService.updateUserById("1");
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" +  redisTestService.getUserById("1"));
        Thread.sleep(31000);
        System.out.println("再过31秒之后调用：" + redisTestService.getUserById("1"));

    }
}
