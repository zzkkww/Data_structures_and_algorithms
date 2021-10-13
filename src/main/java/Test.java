import java.util.ArrayList;

/**
 * @author Kevin
 * @date 2021-09-24
 **/
public class Test {
    public static void main(String[] args) {
//        int t = 1, a = 2, b = -1;
//        if ((a = b) > 0) {
//            t = a++;
//        }
//        System.out.println(t);

        int calc = calc("0000,00010000,10001");
        System.out.println(calc);
    }

    public static int calc(String seats) {
        int result = 0;
        boolean flag = false;
        String[] split = seats.split(",");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("1")) {
                continue;
            }
            if (split[i] == "0" && flag==true) {
                result+=1;
                flag=false;
            }
            flag=true;
        }

        return result;
    }

}
