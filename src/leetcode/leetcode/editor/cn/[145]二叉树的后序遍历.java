package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 607 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            ans.add(tn.val);
            if (tn.left != null) stack.push(tn.left);
            if (tn.right != null) stack.push(tn.right);
        }
        for (int i = 0, sz = ans.size(); i < sz / 2; i++) {
            ans.set(i,ans.get(i) ^ ans.get(sz - 1 - i));
            ans.set(sz - 1 - i,ans.get(i) ^ ans.get(sz - 1 - i));
            ans.set(i,ans.get(i) ^ ans.get(sz - 1 - i));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
