package leetcode.leetcode.editor.cn;//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 752 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int dif = Math.abs(target - ans);
        if (dif == 0) return ans;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k-1]) continue;
                    int sum = nums[i] + nums[j] + nums[k];
                    int dif2 = target - sum;
                    if (Math.abs(dif2) < dif) {
                        dif = Math.abs(dif2);
                        ans = sum;
                    } else if (dif2 < 0){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
