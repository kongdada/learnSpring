package aop.aopXML;

/**
 * @author konglinghui
 * @date 2018/11/13
 */

public class Audience {
    public void silencePhone() {
        System.out.println("before: 手机静音！");
    }

    public void takeSeats() {
        System.out.println("before: 请坐！");
    }

    public void applause() {
        System.out.println("after: 表演结束，鼓掌！！！");
    }

    public void demanRefund() {
        System.out.println("after: 表演失败，退票！！！");
    }
}
