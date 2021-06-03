package leetcode.leetcode.editor.cn;
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 动态规划 
// 👍 888 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution95 {

    private List<TreeNode>[][] memo = null;
    public List<TreeNode> generateTrees(int n) {
        memo = new List[n+1][n+1];
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int i, int n) {
        if (n < i) return Collections.singletonList(null);
        if (n == i) return Collections.singletonList(new TreeNode(i));
        if (memo[i][n] != null) return memo[i][n];
        List<TreeNode> ans = new ArrayList<>();
        for (int j = i; j <= n; j++) {
            List<TreeNode> lefts = generateTrees(i, j-1);
            List<TreeNode> rights = generateTrees(j+1, n);
            for (TreeNode ln : lefts) {
                for (TreeNode rn : rights) {
                    TreeNode tn = new TreeNode(j);
                    tn.left = ln;
                    tn.right = rn;
                    ans.add(tn);
                }
            }
        }
        memo[i][n] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
