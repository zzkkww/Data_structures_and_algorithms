package LeetCode.leetcode.editor.cn;

//////////给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组
//下标
////。 
//////
//////////
////////// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//////////
////////// 你可以按任意顺序返回答案。 
//////////
////////// 
//////////
////////// 示例 1： 
//////////
////////// 
//////////输入：nums = [2,7,11,15], target = 9
//////////输出：[0,1]
//////////解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
////////// 
//////////
////////// 示例 2： 
//////////
////////// 
//////////输入：nums = [3,2,4], target = 6
//////////输出：[1,2]
////////// 
//////////
////////// 示例 3： 
//////////
////////// 
//////////输入：nums = [3,3], target = 6
//////////输出：[0,1]
////////// 
//////////
////////// 
//////////
////////// 提示： 
//////////
////////// 
////////// 2 <= nums.length <= 10⁴ 
////////// -10⁹ <= nums[i] <= 10⁹ 
////////// -10⁹ <= target <= 10⁹ 
////////// 只会存在一个有效答案 
////////// 
//////////
////////// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
////////// Related Topics 数组 哈希表 👍 13350 👎 0
////////
//////
////
//

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class twoSum{
    //2022-02-07 16:31:08
    //两数之和
    //编号：[1]
    
    public static void main(String[] args) {
        int nums[]={3,2,4};
        Solution solution = new twoSum().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if(map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]),i};
                }
                map.put(nums[i],i);
            }
            return null;
        }



//    public int[] twoSum(int[] nums, int target) {
//        //////////输入：nums = [3,2,4], target = 6  通过值拿索引
////////////输出：[1,2]
//        Map<Integer,Integer> map=new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target-nums[i])){
//                return new int[] {map.get(target-nums[i]),i};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }


//        public int[] twoSum2(int[] nums, int target) {
//            //////////输入：nums = [3,2,4], target = 6  通过值拿索引
////////////输出：[1,2]
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (map.containsKey(target-nums[i])){
//
//                    return new int[]{map.get(target-nums[i])};
//                }
//                map.put(nums[i], i);
//            }
//            return null;
//        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
