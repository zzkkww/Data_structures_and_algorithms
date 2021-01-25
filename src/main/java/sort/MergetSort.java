package sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zkw
 * @date 2020-11-20
 **/
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        //归并排序需要一个额外空间
        int temp[] = new int[arr.length];
        mergeSort3(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合方法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //先确定一个中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解   注意这里是mid+1才对
            mergeSort(arr, mid + 1, right, temp);
            //==============一直到这里，才是把数组 分完 还没进行并的操作==========//
            //==================8, 4, 5, 7, 1, 3, 6, 2====================//


            //到合并的时候
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的索引
     * @param temp  做temp的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        //初始化i，左边有序序列的初始索引
        int i = left;

        //初始化j ,右边有序序列的初始索引
        int j = mid + 1;

        //这个是指向temp数组的
        int t = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //知道左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //既将左边的当前元素，拷贝到temp数组
            //然后t后移 i后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                //如果左边的有序序列的当前元素，大于等于右边有序序列的当前元素
                //反之，将右边有序序列当前元素，填充到啊temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            //说明左边的有序序列还有剩余的元素，就全部填充到temp中
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            //为什么是right呢，因为right在后面
            //说明右边的有序序列还有剩余的元素，就全部填充到temp中
            temp[t] = arr[j];
            t++;
            j++;
        }

        //(三)
        //将temp数组的元素拷贝到arr 原数组中
        //注意并不是每次都拷贝所有的  例如8个
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft" + tempLeft + "   right" + right);
        while (tempLeft <= right) {
            //第一次合并的时候tempLeft=0，right=1  //tempLeft=2 right=3  总的一次tempLeft=0 right=3
            //知道最后一次tempLeft=0 right=7
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


    public static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //记住最后拷贝到原有的数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    public static void mergeSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort2(arr, left, mid, temp);
            mergeSort2(arr, mid + 1, right, temp);
            merge2(arr, left, mid, right, temp);
        }
    }


    public static void merge3(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        //注意这里的问题
        int j = mid+1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    public static void mergeSort3(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort3(arr,left,mid,temp);
            mergeSort3(arr,mid+1,right,temp);
            merge3(arr,left,mid,right,temp);
        }
    }
}
