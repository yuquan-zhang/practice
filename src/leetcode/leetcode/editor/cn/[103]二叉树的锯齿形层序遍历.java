package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 450 👎 0


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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(ans,root,0);
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
        if (level % 2 == 0) {
            ln.add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            list.addAll(ln);
            ans.set(level, list);
        }
        levelOrder(ans,root.left,level+1);
        levelOrder(ans,root.right,level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
