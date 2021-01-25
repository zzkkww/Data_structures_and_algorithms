package recursion;

/**
 * 递归问题
 *
 * @author zkw
 * @date 2020-11-15
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(4);

        int factorial = factorial(5);
        System.out.println("factorial:"+factorial);

    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }/*else {
            System.out.println("n="+n);
            如果是这样加的话  只有一个n=2，详细的情况看笔记
        }*/
        System.out.println("n=" + n);
    }

    /**
     * 阶乘问题
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}

