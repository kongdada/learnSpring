package designModel.reflect;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author konglinghui
 * @date 2018/11/26
 */
@Component
public class ReflectService {
    public Object reflect() {
        Person person = null;
        try {
            // 获得对象
            person = (Person) Class.forName("designModel.reflect.Person").getConstructor(String.class).newInstance("kong");
            // 获得方法
            Method method = person.getClass().getMethod("sayHello", String.class);
            // 调用方法
            method.invoke(person, "laiji");
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return person;
    }
}
