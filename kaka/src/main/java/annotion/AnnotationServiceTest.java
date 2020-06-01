package annotion;

/**
 * @author konglinghui01
 * @date 2020/6/1 23:58
 */

@MyAnnotation(value = "this is a annotation")
public class AnnotationServiceTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 拿到加了注解的对象
        Class clazz = new AnnotationServiceTest().getClass();

        boolean useAnnotation = clazz.isAnnotationPresent(MyAnnotation.class);
        // 确保使用了注解
        if (useAnnotation) {
            // 得到注解
            MyAnnotation myAnnotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);

            // 拿到注解中的属性
            System.out.println("value: " + myAnnotation.value());
            System.out.println("name: " + myAnnotation.name());
        }
    }
}
