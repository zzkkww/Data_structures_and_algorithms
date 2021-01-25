package serch;

import java.util.Arrays;

/**
 * 插值查找算法
 *
 * @author zkw
 * @date 2020-11-23
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 100));


    }

    /**
     * 编写插值查找算法
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 意思就是说大于最大的，小于最小的在该数组中
        //记得一定要有，否则得到的mid，可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid 插值查找算法的核心   这就是自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
