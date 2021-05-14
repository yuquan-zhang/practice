package leetcode.leetcode.editor.cn;
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1099 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        if (nextPermutation(nums, 0)) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
        }
    }

    private boolean nextPermutation(int[] nums, int start) {
        if (start >= nums.length - 1) return false;
        if (start == nums.length - 2) {
            if (nums[start] < nums[start+1]) {
                int temp = nums[start];
                nums[start] = nums[start+1];
                nums[start+1] = temp;
                return true;
            }
            return false;
        }
        boolean bool = nextPermutation(nums, start+1);
        if (bool) return true;
        if (nums[start] >= nums[start+1]) return false;
        reverse(nums, start+1);
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[start] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                return true;
            }
        }
        return false;
    }

    private void reverse(int[] nums, int i) {
        int len = nums.length;
        int half = (len - i) / 2;
        for (int j = i; j < i+half; j++) {
            int temp = nums[j];
            nums[j] = nums[len - 1  - (j - i)];
            nums[len - 1 - (j - i)] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        new Solution31().nextPermutation(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
