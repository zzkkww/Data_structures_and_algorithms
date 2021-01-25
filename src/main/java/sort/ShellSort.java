package sort;

import java.util.Arrays;

/**
 * @author zkw
 * @date 2020-11-17
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort3(arr);
    }

    /**
     * 使用逐步推导的方式来rrr编写希尔排序
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        //希尔排序第一轮
        //因为第一轮排序，是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共有5组，每组有2个元素），步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 完整的交换法希尔排序方法
     */
    public static void shellSort2(int[] arr) {
        int temp = 0;
        //上面这一步是为了取步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //下面才是真正的开始
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 移位法：对交换式的希尔排序进行优化，因为交换式效率太慢了
     */
    public static void shellSort3(int[] arr) {
        //也是使用增量的gap，并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        //注意这里的j减了gap 假设gap是5则，5-5=0；所以此处j就是0
                        j -= gap;
                    }
                    //当退出while后，就给temp找到该插入的位置
                    arr[j] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移位法
     */
    public static void shellSort5(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //保存当前初始的索引值
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort6(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
