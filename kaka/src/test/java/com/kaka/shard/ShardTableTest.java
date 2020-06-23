package com.kaka.shard;

import com.kaka.cache.SpringTestCase;
import com.kaka.model.User;
import com.kaka.service.UserService;
import com.kaka.service.shard.ShardBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui01
 * @date 2020/6/22 16:41
 */
public class ShardTableTest extends SpringTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = new User("20", "chaoyang", "boy");
        userService.createUser(ShardBean.builder().subShardKey("0").build(), user);

        User user1 = new User("21", "chaoyang", "boy");
        userService.createUser(ShardBean.builder().subShardKey("1").build(), user1);
    }
}
