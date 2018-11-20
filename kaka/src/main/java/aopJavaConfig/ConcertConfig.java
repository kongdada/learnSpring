package aopJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author konglinghui
 * @date 2018/11/12
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "aopJavaConfig")
public class ConcertConfig {

//    @Bean
//    public Audience audience(){
//        return new Audience();
//    }
//
//    @Bean
//    public EncoreableIntroducer encoreableIntroducer(){
//        return new EncoreableIntroducer();
//    }
}
