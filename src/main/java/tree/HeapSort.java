package tree;

import java.util.Arrays;

/**
 * @author zkw
 * @date 2021-01-25
 **/
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组升序排序
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /**
     * 编写一个堆排序的方法
     */
    public static void heapSort(int[] arr) {
        int temp=0;
//        System.out.println("堆排序开始");
//        //分步完成
//        adjustHeap(arr, 1, arr.length);
//        //4 9 8 5 6
//        System.out.println("第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        //4 9 8 5 6
//        System.out.println("第二次" + Arrays.toString(arr));

        //最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //2.将堆顶元素与末尾元素交换，将最大元素“沉"到数组末端
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
        //直到整个序列有序
        for (int j= arr.length-1;j>0;j--){
            //交换
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组="+Arrays.toString(arr));

    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * <p>
     * eg: int arr[]={4,6,8,5,9}=>i=1=>adjustHeap=>得到{4,9,8,5,6}
     * 如果我们再次调用adjustHeap传入的是i=0 =>得到{4,9,8,5,6}=>{9,6,8,5,4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中索引
     * @param length 表示对多少个元素继续调整，每次调整的length都会减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量里面
        int temp = arr[i];
        //开始调整
        //1、k=i*2+1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //说明左子节点的值小于右子节点的值
                //这样就让左子节点指向右子节点  （为什么要这样做 因为要找一个最大值）
                //就是找左子节点大还是右子节点大 ，如果左大于右 则不++  如果右大于左则++
                k++;
            }
            //如果子节点还大于父节点，为什么temp是父节点呢，因为前面已经存放到变量里面了
            if (arr[k] > temp) {
                //把较大的值赋给当前节点
                arr[i] = arr[k];
                //!!!   i指向k，继续循环比较
                i = k;
            } else {
                break;
            }
        }

        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶（局部   ，以i为节点的）
        //将temp值放到调整后的位置
        arr[i] = temp;

    }
}
