package leetcode.leetcode.editor.cn;
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int p = 0;
        while (p < len) {
            int cur = nums[p];
            if (p == len - 1) return true;
            if (cur == 0) break;
            if (p + cur >= len - 1) {
                return true;
            }
            int max = 0, np = p;
            while (cur-- > 0) {
                np++;
                int temp = np + nums[np];
                if (temp >= max) {
                    max = temp;
                    p = np;
                    if (temp >= len - 1) break;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
