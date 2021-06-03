package leetcode.leetcode.editor.cn;
//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums
//[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
//2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 targ
//et ，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            for (int num : nums) {
                if (num == target) return true;
            }
            return false;
        }
        return search(nums, target, 0, len-1);
    }

    private boolean search(int[] nums, int target, int head, int tail) {
        if (tail <= head + 1) {
            return nums[head] == target || nums[tail] == target;
        }
        int mid = (head + tail) / 2;
        if (nums[mid] == target) return true;
        if (nums[tail] > nums[head]) {
            if (nums[mid] > target) {
                return search(nums,target,head, mid-1);
            } else {
                return search(nums,target,mid+1,tail);
            }
        }
        return search(nums,target,head,mid-1) || search(nums,target,mid+1,tail);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
