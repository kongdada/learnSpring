package bean.JavaConfigBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JaveBeanConfiguration.class)
public class JaveBeanTest {
    @Autowired
    private JaveBeanPlay player;

    @Test
    public void test() {
        player.play();
    }

}
