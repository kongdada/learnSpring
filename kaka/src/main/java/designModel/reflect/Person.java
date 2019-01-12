package designModel.reflect;

/**
 * @author konglinghui
 * @date 2018/11/26
 */

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello(String who) {
        System.err.println("From: " + name + " sayHello To: " + who);
    }
}
