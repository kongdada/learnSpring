package bean.autoBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfiguration.class)
public class AutoTest {
    @Autowired
    private AutoPlay autoPlay;

    @Test
    public void test() {
        autoPlay.play();
    }

}
