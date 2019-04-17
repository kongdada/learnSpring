package AssemblyBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author konglinghui
 * @date 2018/10/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDplayerConfig.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CDplayerTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private Mediaplay player;

    @Test
    public void test() {
        System.out.println(cd.toString());
        System.out.println(player.toString());
    }


}
