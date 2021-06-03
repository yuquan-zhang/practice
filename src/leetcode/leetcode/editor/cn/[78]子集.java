package leetcode.leetcode.editor.cn;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1204 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            combine(ans, nums, new Stack<>(), i, 0);
        }
        return ans;
    }

    private void combine(List<List<Integer>> ans, int[] nums, Stack<Integer> integers, int k, int pre) {
        if (k == 0) {
            ans.add(new ArrayList<>(integers));
        } else {
            for (int i = pre; i < nums.length; i++) {
                integers.push(nums[i]);
                combine(ans,nums,integers,k-1, i+1);
                integers.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
