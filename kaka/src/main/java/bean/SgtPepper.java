package bean;

import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @date 2018/10/30
 */
@Component
public class SgtPepper implements CompactDisc {
    @Override
    public void play(){
        System.out.println("Sing a song!!!");
    }

}
