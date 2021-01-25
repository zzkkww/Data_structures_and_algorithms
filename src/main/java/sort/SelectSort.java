package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author zkw
 * @date 2020-11-16
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1};
        selectSort(arr);
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        //第一轮
        //原始的数组：101,34,,119,1
        //第一轮排序 1,34,119,101

        //第一轮
//        int minIndex=0;
//        int min=arr[0];
//        for (int j = 0+1; j < arr.length; j++) {
//            if (min>arr[j]){
//                //说明假定的最小值并不是最小值，重置下
//                min=arr[j];
//                minIndex=j;
//            }
//        }
//        //进行交换
//        arr[minIndex]=arr[0];
//        arr[0]=min;
//        System.out.println("第一轮后");
//        System.out.println(Arrays.toString(arr));

        /**
         *完整的排序
         */

        for (int i = 0; i < arr.length-1  ; i++) {//这里-1的目的是为了进行几次排序因为这个排序是根据数组的大小-1来确定的
            int minIndex=i;
            int min=arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                //如果没有进行了index没有进行了交换就不需要进行这个操作
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            System.out.println("第:"+i+"数组");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));

    }
}
