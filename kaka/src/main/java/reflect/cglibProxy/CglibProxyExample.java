package reflect.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import reflect.JdkProxy.HelloWorldImpl;

import java.lang.reflect.Method;

/**
 * @author konglinghui
 * @date 2018/11/26
 */

public class CglibProxyExample implements MethodInterceptor {

    public Object getProxy(Class cls) {
        //增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        // 制定代理逻辑实现对象
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     *    代理逻辑方法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB进入代理逻辑");
        System.out.println("CGLIB调度真实对象之前的操作");
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("CGLIB调度真是对象之后的操作");
        return result;

    }

    public static void main(String args[]){
        CglibProxyExample cpe = new CglibProxyExample();
        HelloWorldImpl obj  = (HelloWorldImpl)cpe.getProxy(HelloWorldImpl.class);
        obj.sayHello();
    }
}
