package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zkw
 * @date 2020-11-16
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        insertSort2(arr);
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        //第一轮{101, 34, 119, 1}=》{34,101，119,1}

        //定义待插入的数
//        int insertVal = arr[1];
//        //既arr[1]的前面这个数的下标
//        int insertIndex = 1 - 1;
//
//        //给insertVal找到插入的位置
//        //说明
//        //1、insertIndex>=0保证不会越界
//        //2、insertVal<arr[insertIndex] 待插入的数还没找到插入的位置
//        //3、就需要将arr[insertIndex]后移
//        while (insertIndex >= 0 && insertVal<arr[insertIndex]){
//            arr[insertIndex+1]=arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，insertIndex+1
//        //举例  101, 334, 119, 1
//        arr[insertIndex+1]=insertVal;
//        System.out.println(Arrays.toString(arr));

        /**
         * 完整的过程
         */

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            /**
             * 待插入的值小于前一个索引的值才进入这个while循环
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //优化判断它是否需要赋值
            if (insertIndex+1!=i){
                arr[insertIndex + 1] = insertVal;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort2(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex+1]=insertValue;
        }
        System.out.println("插入排序执行完毕："+Arrays.toString(arr));

    }
}
