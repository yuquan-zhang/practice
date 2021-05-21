package leetcode.leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1365 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(getList(nums));
        int sum = 1;
        while (len > 1) {
            sum *= len;
            len--;
        }
        len = nums.length;
        int i = len - 1;
        int ct = 1;
        while (ct++ < sum) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
            ans.add(getList(nums));
            if (ct % 120 == 0) {
                i = len - 5;
            } else if (ct % 24 == 0) {
                i = len - 4;
            } else if (ct % 6 == 0) {
                i = len - 3;
            } else if (ct % 2 == 0) {
                i = len - 2;
            } else {
                i = len - 1;
            }
        }
        return ans;
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6};
        System.out.println(new Solution().permute(test));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
