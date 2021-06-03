package leetcode.leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 592 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n) return ans;
        combine(ans, n, new Stack<>(), k, 0);
        return ans;
    }

    private void combine(List<List<Integer>> ans, int n, Stack<Integer> integers, int k, int pre) {
        if (k == 0) {
            ans.add(new ArrayList<>(integers));
        } else {
            for (int i = pre; i < n; i++) {
                integers.push(i+1);
                combine(ans,n,integers,k-1, i+1);
                integers.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
