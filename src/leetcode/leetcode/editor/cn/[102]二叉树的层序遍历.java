package leetcode.leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 887 👎 0


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
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(ans, root, 0);
        return ans;
    }

    private void levelOrder(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) return;
        List<Integer> ln;
        if (ans.size() > level) {
            ln = ans.get(level);
        } else {
            ln = new ArrayList<>();
            ans.add(ln);
        }
        ln.add(root.val);
        levelOrder(ans,root.left,level+1);
        levelOrder(ans,root.right,level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
