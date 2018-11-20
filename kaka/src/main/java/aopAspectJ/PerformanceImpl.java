package aopAspectJ;

/**
 * @author konglinghui
 * @date 2018/11/12
 */
public class PerformanceImpl implements Performance {
    @Override
    public String perform() {
        try {
            System.out.println("演出～～～");
        } catch (Exception e) {
            throw e;
        }
        return new String("嗒嗒嗒");
    }
}
