package aop.aopJavaConfig;

import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @date 2018/11/13
 */
@Component
public class EncoreableImpl implements Encoreable{
    @Override
    public void performEncore(){
        System.out.println("返场表演～～～");
    }
}
