package designModel.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author konglinghui
 * @date 2018/11/26
 */

public class JdkProxyExample implements InvocationHandler {
    private Object target = null;

    public Object bind(Object target) {
        this.target = target;
        // 生成一个动态代理对象并且挂在目标对象对应的接口下--就是这儿需要接口
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑");
        System.out.println("调度真实对象之前的操作");
        Object obj = method.invoke(target, args);
        System.out.println("调度真实对象之后的操作");
        return obj;
    }

    public static void main(String args[]) {
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHello();
    }
}
