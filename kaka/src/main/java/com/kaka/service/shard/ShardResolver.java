package com.kaka.service.shard;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ShardResolver {

    @Pointcut(value = "@annotation(com.kaka.service.shard.ShardEnabled)")
    private void anyMethod() {
    }

    @Around("anyMethod()")
    private Object doCheckShardKey(ProceedingJoinPoint joinPoint) throws Throwable {
       // 拿到使用了注解的方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (method == null || !method.isAnnotationPresent(ShardEnabled.class)) {
            return joinPoint.proceed();
        }

        // 拿到使用了注解的方法的参数
        Object[] args = joinPoint.getArgs();
        if (null == args || args.length == 0) {
            throw new RuntimeException("#####sharding need some sharding keys in params.");
        }
        // 拿到第一个参数shardBean
        Class clz = args[0].getClass();
        if (!(ShardBean.class.equals(clz) || ShardBean.class.equals(clz.getSuperclass()))) {
            throw new RuntimeException("#####sharding need a ShardBean in the first param.");
        }
        ShardBean shardBean = (ShardBean) args[0];
        // 塞进容器
        ShardKeyHolder.setShardBean(shardBean);
        return joinPoint.proceed();
    }
}
