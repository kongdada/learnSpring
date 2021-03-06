package commTool;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

/**
 * @author konglinghui
 * @date 2019-02-28
 */

public class StringTool {
    /**
     * @param date
     * @param separator
     * @return
     */
    public static String getMonthDay(String date, String separator) {
        return date.replaceAll("-", separator).substring(5);
    }

    /**
     * %1参数是顺序，$s被替代的字符串
     */
    public static void testStringFormat() {
        String bussineTitle = "业务范围, 环比%1$svs%2$s差值, 环比%1$svs%2$s环比, 同比%1$svs%3$s差值, 同比%1$svs%2$s同比, %1$s大竞价消耗, %2$s大竞价消耗, %3$s大竞价消耗";
        System.out.println(String.format(bussineTitle, "2018-12-12", "2018-12-11", "2018-12-05"));

    }

    /**
     * 字符串用特定符号连接
     */
    public static void stringConcatByAnyting() {
        List<String> kaCser = Arrays.asList("a", "b", "c");
        String str = Joiner.on(",").join(kaCser);
//        String str2 = StringUtils.join(kaCser, ",");
        System.out.println("字符串用特定符号连接：" + str);
//        System.out.println("字符串用特定符号连接："+str2);
    }

    public static void spiltStringByBank() {
        String str = "2019 05 02";
        String[] strArr = str.split(" +");
        for (String temp : strArr) {
            System.out.println(temp);
        }
    }

    public static void spiltStringByPoint() {
        String str = "2019.05.02";
        String[] strArr = str.split("\\.");
        for (String temp : strArr) {
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        Long a = 910171671029387103L;
        Integer b = a.intValue();

        System.out.println(b);
    }
}
