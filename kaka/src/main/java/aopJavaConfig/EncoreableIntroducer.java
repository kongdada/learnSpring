package aopJavaConfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author konglinghui
 * @date 2018/11/13
 */
@Aspect
public class EncoreableIntroducer {
    /**
     * 此注解可以将新加的接口引入到原来调用目标函数的bean中
     */
    @DeclareParents(value = "aopJavaConfig.Performance+", defaultImpl = EncoreableImpl.class)
    public static Encoreable encoreable;
}
