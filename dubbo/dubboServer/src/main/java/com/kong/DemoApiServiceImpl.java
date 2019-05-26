package com.kong;

public class DemoApiServiceImpl implements DemoApiService {
    public String getUser(Long userId) {
        System.out.println("生产者调用消费者服务接口userId:" + userId);

        String res = null;
        switch (userId.intValue()) {
            case 1:
                res = "userId: 1";
                break;
            case 2:
                res = "userId: 2";
                break;
            case 3:
                res = "userId: 3";
                break;
            default:
                break;
        }

        return res;
    }
}
