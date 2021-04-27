package leetcode.leetcode.editor.cn;//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 822 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int k = nums.length-1;
                for (int m = j+1; m < nums.length - 1; m++) {
                    if (m > j+1 && nums[m] == nums[m-1]) continue;
                    while (m < k && nums[i] + nums[j] + nums[m] + nums[k] > target) {
                        k--;
                    }
                    if (m >= k) break;
                    if (nums[i] + nums[j] + nums[m] + nums[k] == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[m], nums[k]));
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
