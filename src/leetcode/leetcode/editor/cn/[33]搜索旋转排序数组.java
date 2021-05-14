package leetcode.leetcode.editor.cn;
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < len）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        if (len < 4) {
            for (int i = 0; i < len; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }
        int head = 0, tail = len - 1;
        int mid = (head + tail) / 2;
        int k = 0;
        if (nums[head] > nums[tail]) { // 有旋转，先找最小值下标
            while (head != mid && tail != mid) {
                if (nums[mid] > nums[tail]) {
                    head = mid;
                } else {
                    tail = mid;
                }
                mid = (head + tail) / 2;
            }
            // 多次二分之后确定了最小值不是nums[head]就是nums[tail]。
            if (nums[head] < nums[tail]) {
                k = head;
            } else {
                k = tail;
            }

        }
        head = 0;
        tail = len - 1;
        mid = (head + tail) / 2;
        while (head != mid && tail != mid) {
            int r = (mid + k) % len;
            if (nums[r] == target) return r;
            if (nums[r] < target) {
                head = mid;
            } else {
                tail = mid;
            }
            mid = (head + tail) / 2;
        }
        if (nums[(head + k) % len] == target) return (head + k) % len;
        if (nums[(tail + k) % len] == target) return(tail + k) % len;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
