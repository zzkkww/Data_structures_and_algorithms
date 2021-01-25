package sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author zkw
 * @date 2020-11-22
 **/
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);

    }

    public static void radixSort2(int[] arr) {
        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCounts = new int[10];

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int maxLength = ("" + max).length();


    }


    public static void radixSort(int[] arr) {
        //第一轮（针对每个元素的个位进行排序处理）

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组

        //1、二维数组包含10个一维数组1
        //2、为了防止在放入数的时候，数据溢出，则每一个一维数组（桶），大小定义为arr.length
        //所以桶排序十分的占用空间    空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这样理解bucketElementCounts[],记录的就是bucket[0]桶的每次放入数据的个数
        int[] bucketElementCounts = new int[10];


        //得到规律
        //1、得到数组中最大的数的位数
        int max = arr[0];//假设第一个数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        //循环处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素的对应位数进行排序处理，第一次是个位，第二次是十位，第三次是百位
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应的位数的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }
            //按照这个桶的顺序（以数组的下标依次取出数据，放回原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中数据，放入的原来的数组中     说白了这个k的大小就是10
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有，数据。我们才放到原数组中
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，即第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第i轮处理后，需要将每个bucketElementCounts[k]=0!!!!! 一定要记住
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + Arrays.toString(arr));
        }


        //第一轮（针对每个元素的个位进行排序处理）
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位值
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（以为数组的下标依次取出数据，放回原来数组）
        int index = 0;
        //遍历每一个桶，并将桶中数据，放入的原来的数组中     说白了这个k的大小就是10
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有，数据。我们才放到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶，即第k个一维数组，放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后，需要将每个bucketElementCounts[k]=0!!!!! 一定要记住
            bucketElementCounts[k] = 0;
        }
        System.out.println("第一轮" + Arrays.toString(arr));


        //第二轮（针对每个元素的个位进行排序处理）
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位值
            int digitOfElement = arr[j] / 10 % 10;//748/10=74==>74%10=4
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（以为数组的下标依次取出数据，放回原来数组）
        index = 0;
        //遍历每一个桶，并将桶中数据，放入的原来的数组中     说白了这个k的大小就是10
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有，数据。我们才放到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶，即第k个一维数组，放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后，需要将每个bucketElementCounts[k]=0!!!!! 一定要记住
            bucketElementCounts[k] = 0;
        }
        System.out.println("第二轮" + Arrays.toString(arr));


        //第三轮（针对每个元素的个位进行排序处理）
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位值
            int digitOfElement = arr[j] / 100 % 10;//748/10=74==>74%10=4
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（以为数组的下标依次取出数据，放回原来数组）
        index = 0;
        //遍历每一个桶，并将桶中数据，放入的原来的数组中     说白了这个k的大小就是10
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有，数据。我们才放到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶，即第k个一维数组，放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后，需要将每个bucketElementCounts[k]=0!!!!! 一定要记住
            bucketElementCounts[k] = 0;
        }
        System.out.println("第三轮" + Arrays.toString(arr));

    }
}
