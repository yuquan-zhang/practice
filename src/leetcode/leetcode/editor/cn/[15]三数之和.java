package leetcode.leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3194 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j >= k) continue;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
