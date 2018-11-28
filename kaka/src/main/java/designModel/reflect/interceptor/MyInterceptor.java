package designModel.reflect.interceptor;

import java.lang.reflect.Method;

/**
 * @author konglinghui
 * @date 2018/11/27
 */

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args){
        System.out.println("反射方法前逻辑");
        // 不反射被代理对象原有方法
        return false;
    }
    @Override
    public void around(Object proxy, Object target, Method method, Object[] args){
        System.out.println("取代代理对象的方法执行");
    }
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args){
        System.out.println("反射方法后逻辑");
    }

}
