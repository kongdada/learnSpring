package bean.autoBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author konglinghui01
 * @date 2020/5/31 16:59
 */
public class MyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfiguration.class);
        ServiceDemo service = context.getBean(ServiceDemo.class);
//        service.test();
    }
}
