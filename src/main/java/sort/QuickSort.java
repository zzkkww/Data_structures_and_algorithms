package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author zkw
 * @date 2020-11-17
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        qucikSortDemo10(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qucikSortDemo11(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (l>r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        //因为r一直在减小 也就是r一直往左移 ，所以我们的排序还是要一直往左找
        if (left<r){
            qucikSortDemo10(arr,left,r);
        }
        //因为l一直在增大 也就是往右找
        if (right>l){
            qucikSortDemo10(arr,l,right);
        }
    }


    public static void qucikSortDemo10(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            qucikSortDemo10(arr, left, r);
        }
        if (right > l) {
            qucikSortDemo10(arr, l, right);
        }

    }

    public static void quickSortDemo9(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            qucikSortDemo8(arr, left, r);
        }
        if (right > l) {
            qucikSortDemo8(arr, l, right);
        }
    }

    public static void qucikSortDemo8(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            qucikSortDemo8(arr, left, r);
        }
        if (right > l) {
            qucikSortDemo8(arr, l, right);
        }

    }


    public static void qucikSortDemo7(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] < pivot) {
                r--;
            }
            if (arr[r] > pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            qucikSortDemo7(arr, left, r);
        }
        if (right > l) {
            qucikSortDemo7(arr, l, right);
        }


    }

    public static void quickSortDemo6(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            if (arr[l] < pivot) {
                l++;
            }
            if (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (pivot == arr[l]) {
                r--;
            }
            if (pivot == arr[r]) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSortDemo6(arr, left, r);
        }
        if (right > l) {
            quickSortDemo6(arr, l, right);
        }

    }


    public static void quickSortDemo3(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            if (arr[l] < pivot) {
                l++;
            }
            if (arr[r] > pivot) {
                r--;
            }
            if (l > r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                l++;
            }
            if (arr[r] == pivot) {
                r--;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSortDemo3(arr, left, r);
        }
        if (right > l) {
            quickSortDemo3(arr, l, right);
        }
    }


    public static void quickSortDemo2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            if (arr[l] < pivot) {
                l++;
            }
            if (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSortDemo2(arr, left, r);
        }
        if (right > l) {
            quickSortDemo2(arr, l, right);
        }
    }

    public static void quickSortDemo1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果l==r，必须l++,r--,否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSortDemo1(arr, left, r);
        }
        if (right > l) {
            quickSortDemo1(arr, l, right);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        //左指针
        int l = left;
        //右指针
        int r = right;
        //pivot中轴，即选取数组的中间来进行取一个基准值
        int pivot = arr[(left + right) / 2];
        //临时变量，作为交换时的使用
        int temp = 0;
        //while循环的目的是让比pivot值小放到左边
        //比pivot值大的放到右边
        while (l < r) {
            //在pivot的左边一直找，找到一个大于等于pivot,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到一个小于等于pivot,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pivot的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部都是大于等于pivot的值
            if (l >= r) {
                break;
            }
            //经过上面的步骤之后，就可以交换了
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l]==pivot,前移了一步
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r]==pivot,后移了一步
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r，必须l++,r--,否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归   为什么不用right呢，因为这样r是在不断的变化的所以
        //不能使用right
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    public static void quickSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp;

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果l==r，必须l++,r--,否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归   为什么不用right呢，因为这样r是在不断的变化的所以
        //不能使用right
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
