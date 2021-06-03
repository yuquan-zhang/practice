package leetcode.leetcode.editor.cn;
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1174 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    private int[][] memo = null;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        if (memo[start][end] != 0) return memo[start][end];
        int ans = 0;
        for (int i = start; i <= end; i++) {
            int ln = numTrees(start, i-1);
            int rn = numTrees(i + 1, end);
            if (ln != 0 && rn != 0) ans += ln * rn;
            else ans += ln + rn;
        }
        memo[start][end] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
