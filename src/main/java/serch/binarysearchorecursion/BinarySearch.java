package serch.binarysearchorecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 使用二分查找的前提，该数组一定是有序的
 *
 * @author zkw
 * @date 2020-11-23
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};

        int resIndex = binarySearchDemo2(arr, 0, arr.length - 1, 89);
        System.out.println("resIndex" + resIndex);

//        int arr1[] = {1, 8, 10, 89, 1000, 1000, 1234};
//        ArrayList<Integer> list = binarySearch3(arr1, 0, arr1.length - 1, 1000);
//        System.out.println(list);
//        Map map=new HashMap();
//        ConcurrentHashMap<Object, Object> map12 = new ConcurrentHashMap<>();
    }


    public static int binarySearchDemo2(int []arr,int left,int right,int findVal){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];

        if (findVal>midVal){
            return binarySearchDemo2(arr,mid+1,right,findVal);
        }
        if (findVal<midVal){
            return binarySearchDemo2(arr,left,mid-1,findVal);
        }

        return mid;
    }

    public static int binarySearchDemo1(int[] arr,int left,int right,int findVal ){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];


         //二选一的情况
        if (findVal>midVal){
            //就像左找
            return binarySearchDemo1(arr,mid+1,right,findVal);
        }
        if (findVal<midVal){
            return binarySearchDemo1(arr,left,mid-1,findVal);
        }
        return mid;
    }


    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到返回下标，否则就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else { //findVal==midVal
            return mid;
        }
    }


    //完成一个课后思考题  {1,8,10,89,1000，1000,1234} 有相同值就返回多个索引

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {

            //int arr1[] = {1, 8, 10, 89, 1000, 1000,1234}; mid=3 midVal=89  递归第二次进入  left=4  mid=（4+6）/2=5 midVal=1000
            //findVal==midVal
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向mid索引值的左边扫描，将所有满足1000的元素的下标的，加入到ArrayList集合中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则就将temp，放入到resIndexList
                resIndexList.add(temp);
                temp--;
            }

            //这里是把这个中间值等于要findValue的先放进去 要不然会少一个值
            resIndexList.add(mid);
            //向mid索引值的右边边扫描，将所有满足1000的元素的下标的，加入到ArrayList集合中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则就将temp，放入到resIndexList
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }


    public static ArrayList<Integer> binarySearch3(int[] arr, int left, int right, int findValue) {

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findValue > midValue) {
            return binarySearch3(arr, mid + 1, right, findValue);
        } else if (findValue<midValue) {
            return binarySearch3(arr, left, mid - 1, findValue);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            //向左查询
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp--;
            }

            list.add(mid);

            //向右查询
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                list.add(temp);
                temp++;
            }

            return list;
        }
    }
}
