package bean.autoBean;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author konglinghui01
 * @date 2020/5/31 17:01
 * lazy懒加载
 */
@Service
//@Lazy
@Scope("prototype")
public class ServiceDemo implements InitializingBean {
    @Autowired
    private AutoDisc autoDisc;


    /**
     * 1. 这个类本身先被初始化
     */
    ServiceDemo() {
        System.out.println("construct service demo！！！");
    }

    public void test() {
        autoDisc.play();
    }

    /**
     * 2. 被这个注释修饰的方法在类被初始化之后调用
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("this is a postConstruct !!!");
    }

    /**
     * 3. 实现InitializingBean的afterPropertiesSet方法
     * 这个也是在类被初始化完成后调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is a initializingBean");
    }
}
