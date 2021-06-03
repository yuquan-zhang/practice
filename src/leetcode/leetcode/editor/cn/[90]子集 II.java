package leetcode.leetcode.editor.cn;
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 583 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
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
                if (i > pre && nums[i] == nums[i-1]) continue;
                integers.push(nums[i]);
                combine(ans,nums,integers,k-1, i+1);
                integers.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
