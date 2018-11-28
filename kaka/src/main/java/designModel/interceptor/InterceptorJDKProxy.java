package designModel.interceptor;

import designModel.JdkProxy.HelloWorld;
import designModel.JdkProxy.HelloWorldImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author konglinghui
 * @date 2018/11/27
 */

public class InterceptorJDKProxy implements InvocationHandler {
    // 真实对象
    private Object target = null;
    // 拦截器全名限定
    private String interceptorClass = null;

    public InterceptorJDKProxy(Object target, String className) {
        this.target = target;
        this.interceptorClass = className;
    }

    public static Object bind(Object target, String InterceptorName) {
        // 生成一个动态代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJDKProxy(target, InterceptorName));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            // 没设置拦截器，直接返回原方法调用
            return method.invoke(target, args);

        }

        Object result = null;
        // 通过反射，得到一个拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        // 拦截调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            // 前置逻辑执行完毕，执行真实对象的逻辑
            result = method.invoke(target, args);
        } else {
            // 前置方法失败，执行around逻辑
            interceptor.around(proxy, target, method, args);
        }
        // 最后执行后置方法逻辑
        interceptor.after(proxy, target, method, args);
        return result;
    }

    public static void main(String args[]) {
        HelloWorld proxy = (HelloWorld) InterceptorJDKProxy.bind(new HelloWorldImpl(), "designModel.interceptor.MyInterceptor");
        proxy.sayHello();
        System.out.println("######################");

        HelloWorld proxy1 = (HelloWorld) InterceptorJDKProxy.bind(new HelloWorldImpl(), "designModel.interceptor.multiInterceptor.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJDKProxy.bind(proxy1, "designModel.interceptor.multiInterceptor.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJDKProxy.bind(proxy2, "designModel.interceptor.multiInterceptor.Interceptor3");
        proxy3.sayHello();

    }
}
