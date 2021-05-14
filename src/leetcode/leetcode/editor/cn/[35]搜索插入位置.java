package leetcode.leetcode.editor.cn;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 911 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) {
            if (nums[0] < target) return 1;
            return 0;
        }
        int s = 0, e = len - 1;
        int m = (s + e) / 2;
        while (m != s && m != e) {
            if (nums[m] == target) return m;
            if (nums[m] > target) {
                if (m > 0 && nums[m-1] < target) return m;
                e = m;
            } else {
                if (m < len - 1 && nums[m+1] > target) return m+1;
                s = m;
            }
            m = (s + e) / 2;
        }
        if (target <= nums[s]) return s;
        if (target > nums[s] && target <= nums[e]) return e;
        if (target > nums[e]) return e+1;
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
