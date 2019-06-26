package aop.aopXML;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author konglinghui
 * @date 2018/11/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringAOP.xml")
public class PerformanceTest {

    @Autowired
    private Performance performance;

    @Test
    public void test() {
        performance.perform();
        System.out.println("+++++++++++++++++++++++++++++++++++");
        Encoreable encoreable = (Encoreable)performance;
        encoreable.performEncore();
    }

}