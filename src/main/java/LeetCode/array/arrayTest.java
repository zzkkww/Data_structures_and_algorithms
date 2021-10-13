package LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @date 2021-09-17
 **/
public class arrayTest {


    public static void main(String[] args) {
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
        Map<Integer, Integer> tongji = tongji(arr);
        System.out.println(tongji);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : tongji.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            System.out.println("key===="+key+"=======value====>"+value);
        }
    }


   public static Map<Integer,Integer> tongji(int [] arr){
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i : arr) {
           Integer num = map.get(i);
           map.put(i,num==null?1:num+1);
       }

       return map;
    }
}
