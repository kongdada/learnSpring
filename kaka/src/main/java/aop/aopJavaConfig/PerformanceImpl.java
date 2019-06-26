package aop.aopJavaConfig;

import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @date 2018/11/12
 */
@Component
public class PerformanceImpl implements Performance {
    @Override
    public void perform(){
        System.out.println("演出～～～");
    }
}
