package recursion;

/**
 * @author zkw
 * @date 2020-11-15
 **/
public class Queue8 {
    /**
     * 定义一个max表示共有多少个皇后
     */
    int max = 8;
    //定义一个数组array,保存皇后放置的结果，比如arr={0,4,7,5,2,6,1,3}\
    int[] array = new int[max];

    static int count=0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println(count);
    }


    /**
     * 编写一个方法，防止第n个皇后
     *
     * 特别注意：check是每一次递归时，进入到check中都有for (int i = 0; i < max; i++)
     */
    private void check(int n) {
        if (n == max) {
            //n=8的时候其实8个皇后就已经放好了
            print();
            return;
        }

        //一次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第1列
            array[n]=i;
            //判断当防止第n个皇后到i列是，是否冲突
            if (judge(n)){
                //不冲突，则接着放n+1个皇后，既开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n]=i,即将第n个皇后，放置在本行后移的一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突的方法
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        /**
         *1、array[i]==array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
         *2、 Math.abs(n-i)==Math.abs(array[n]-array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线上
         判断的这一个是否在同一斜线上 是与这个定义的数组有关系的

         3、没有必要判断同一行，因为n每次都在递增
         */
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * 写一个方法，可以将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

}
