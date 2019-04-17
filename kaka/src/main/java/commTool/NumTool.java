package commTool;

public class NumTool {

    public static void autoAdd(){
        int sum = 0;
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            count = ++count;
//            count = count++;
        }
        System.out.println(sum*count);
    }
}
