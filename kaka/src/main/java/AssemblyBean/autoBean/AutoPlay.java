package AssemblyBean.autoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoPlay {
    @Autowired
    private AutoDisc cd;

    public AutoPlay(AutoDisc cd) {
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
}
