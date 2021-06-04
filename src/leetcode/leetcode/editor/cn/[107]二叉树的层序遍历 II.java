package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 444 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderBottom(ans,root,0);
        int size = ans.size();
        for (int i = 0; i < size / 2; i++) {
            List<Integer> temp = ans.get(i);
            ans.set(i, ans.get(size - 1 - i));
            ans.set(size - 1 - i, temp);
        }
        return ans;
    }

    private void levelOrderBottom(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) return;
        List<Integer> ln;
        if (ans.size() > level) {
            ln = ans.get(level);
        } else {
            ln = new ArrayList<>();
            ans.add(ln);
        }
        ln.add(root.val);
        levelOrderBottom(ans,root.left,level+1);
        levelOrderBottom(ans,root.right,level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
