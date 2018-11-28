package designModel.interceptor;

import java.lang.reflect.Method;

/**
 * @author konglinghui
 * @date 2018/11/27
 */

public interface Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy, Object target, Method method, Object[] args);
}
