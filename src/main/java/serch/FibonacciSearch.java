package serch;

import java.util.Arrays;

/**
 * @author zkw
 * @date 2020-11-23
 **/
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(fibSearch(arr,1000));
    }

    //因为后面我们的mid=low+F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列

    /**
     * 非递归的方式得到一个斐波那契数列   也可以使用递归的方式得到
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        //这里直接使用视频的算法的斐波那契数列，不是那个0 1 1 2 3 省略了0
//        f[0]=1;
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 编写斐波那契查找算法
     * 这里使用的是非递归的方式编写算法
     *
     * @param a   数组
     * @param key 我们需要查找的关键码（就是我们查找的值）
     * @return 返回对应的下标，如果没有则返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        //表示斐波那契分割数值的下标   要取的那个  每次都会变化的
        int k = 0;
        //存放mid值
        int mid = 0;
        //获取到斐波那契数列
        int f[] = fib();
        //获取到斐波那契数列分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值可能大于a数组的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[] 就算是扩容
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需要使用a数组的最后的数填充temp 最好不要用0
        //eg:temp = {1, 8, 10, 89, 1000, 1234,0,0,0}==>{1, 8, 10, 89, 1000, 1234,1234,1234,1234};
        for (int i = high + 1; i < temp.length; i++) {
            temp[i]=a[high];
        }

        //使用while来循环处理，找到我们的数key
        while (low<=high){
            //只要这个条件满足，就可以找
            mid=low+f[k-1]-1;
            if (key<temp[mid]){
                //说明我们应该继续向数组的前面查找，也就是左边
                high=mid-1;
                //为什么是k--
                //说明
                //1、全部元素=前面元素+后边元素
                //2、f[k]=f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素，所以可以继续f[k-1]=f[k-1-1]+f[k-2-1]
                //即在f[k-1]的前面继续查找
                //即下次循环mid=f[k-1-1]-1
                k--;
            }else if (key>temp[mid]){
                //我们应该继续向数组的后面查找（右边）
                low=mid+1;
                //为什么是k-=2呢
                //1、全部元素=前面元素+后边元素
                //2、f[k]=f[k-1]+f[k-2]
                //3、因为后面我们有f[k-2] 所以我们可以继续拆分f[k-1]=f[k-3]+f[k-4]
                //4、即在f[k-2]的前面进行查找k-=2
                //5、即下次循环mid=f[k-1-2]-1
                k-=2;
            }else {
                //找到了
                //需要确定，发挥的是那个下标
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
