package serch.binarysearchorecursion;

/**
 * 二分查找的非递归方式实现
 *
 * @author zkw
 * @date 2021-04-01
 **/
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index=binarySearch(arr,1);

        System.out.println(index);
    }

    /**
     * 默认传进来的数组是升序的
     *
     * @param arr    待查找的数组
     * @param target 需要查找的数
     * @return 返回对应的下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //说明可以继续查找
        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                //这时候不使用递归去查找了，需要向左边查找
                right = mid - 1;
            } else {
                //需要向右边查找
                left = mid + 1;
            }
        }

        return -1;
    }
}
