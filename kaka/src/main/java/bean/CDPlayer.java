package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @date 2018/11/1
 */
@Component
public class CDPlayer implements Mediaplay {

    @Autowired
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play(){
        cd.play();
    }


}
