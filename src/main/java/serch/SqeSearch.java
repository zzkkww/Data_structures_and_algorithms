package serch;

/**
 * 线性查找
 *
 * @author zkw
 * @date 2020-11-23
 **/
public class SqeSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};

        int index=seqSearch(arr,11);
        if (index==-1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到了"+index);
        }


    }

    /**
     * 这里我们实现的线性查找是找到一个
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int []arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
