package leetcode.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 995 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1,-1};
        int s1 = 0, s2 = 0;
        int e1 = len - 1, e2 = len - 1;
        int m1 = (s1 + e1) / 2, m2 = (s2 + e2) / 2;
        while (m1 != s1 && m1 != e1) {
            if (nums[m1] == target) {
                if (m1 == 0 || nums[m1-1] < target) {
                    break;
                } else {
                   e1 = m1; 
                }
            } else if (nums[m1] > target) {
                e1 = m1;
            } else {
                s1 = m1;
            }
            m1 = (s1 + e1) / 2;
        }
        if (nums[s1] == target) m1 = s1;
        while (m2 != s2 && m2 != e2) {
            if (nums[m2] == target) {
                if (m2 == len-1 || nums[m2+1] > target) {
                    break;
                } else {
                    s2 = m2;
                }
            } else if (nums[m2] > target) {
                e2 = m2;
            } else {
                s2 = m2;
            }
            m2 = (s2 + e2) / 2;
        }
        if (nums[e2] == target) m2 = e2;
        if (nums[m1] == target && nums[m2] == target) return new int[]{m1, m2};
        if (nums[m1] != target && nums[m2] == target) return new int[]{m2, m2};
        if (nums[m1] == target && nums[m2] != target) return new int[]{m1, m1};
        return new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
