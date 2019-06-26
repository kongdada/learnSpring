package bean.JavaConfigBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaveBeanConfiguration {
    @Bean
    public JaveBeanDisc javeBeanDisc(){
        return new JaveBeanDisc();
    }

    // 注入依赖
    @Bean
    public JaveBeanPlay javeBeanPlay(){
        return new JaveBeanPlay(javeBeanDisc());
    }

}
