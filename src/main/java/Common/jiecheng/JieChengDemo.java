package Common.jiecheng;

/**阶乘
 * @author zkw
 * @date 2021-04-02
 **/
public class JieChengDemo {
    public static void main(String[] args) {

        int result = result(10);
        System.out.println(result);

    }


    public static int result(int num){
        if (num<0){
            System.out.println("非法请求参数");
            return -1;
        }
        if (num==2){
            return 2;
        }else {
            return result(num-1)*num;
        }


    }
}
