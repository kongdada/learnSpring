package AssemblyBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @date 2018/10/30
 */
@Configuration
//@ComponentScan("AssemblyBean")
//@ComponentScan(basePackages = "AssemblyBean")
//@ComponentScan(basePackages = {"AssemblyBean"})
//@ComponentScan(basePackageClasses = {CompactDisc.class})
public class CDplayerConfig {
    @Bean
    public CompactDisc Sgtpepper(){
        return new SgtPepper();
    }
    @Bean
    public Mediaplay CDplayer(){
        return new CDPlayer(Sgtpepper());
    }
    // 最佳
    @Bean
    public Mediaplay CDplayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

}
