package Common.fibonaqi;

/** 斐波那契数列
 * @author zkw
 * @date 2021-04-02
 **/
public class FibonaqiDemo {
    public static void main(String[] args) {
        int i = result1();
        System.out.println(i);

//        int result = result(10);
//        System.out.println(result);
    }

    public static int result(int num){
        if (num<0){

            return -1;
        }
        if (num==1 || num==2){
            return 1;
        }else {
            return result(num-1)+result(num-2);
        }
    }

    private static int result1(){

        try {
            int i=1/0;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }
}
