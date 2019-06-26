package aop.aopAspectJ;

/**
 * @author konglinghui
 * @date 2018/11/16
 *
 */
public aspect Audience {

    pointcut perFormance(): execution(* aop.aopAspectJ.Performance.perform(..));

    before(): perFormance(){
        System.out.println("表演前：手机静音！");
    }

    before(): perFormance(){
        System.out.println("表演前：请坐！");
    }

    after(): perFormance(){
        System.out.println("表演后：鼓掌！！！");
    }

    after()returning(String str): perFormance(){
        System.out.println("调用成功，表演很精彩，鼓掌！！！");
    }

    after()throwing(Exception e): perFormance(){
        System.out.println("调用失败，表演失败，退票！！！");
    }
}
