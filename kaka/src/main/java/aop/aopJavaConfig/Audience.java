package aop.aopJavaConfig;

import org.aspectj.lang.annotation.*;

/**
 * @author konglinghui
 * @date 2018/11/12
 * 定义切面，定义切点
 */
@Aspect
public class Audience {

    @Pointcut("execution(* aop.aopJavaConfig.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
     public void silencePhone(){
        System.out.println("手机静音！");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("请坐！");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("表演结束，鼓掌！！！");
    }

    @AfterThrowing("performance()")
    public void demanRefund(){
        System.out.println("表演失败，退票！！！");
    }
}
