package leetcode.leetcode.editor.cn;
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 512 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
class Solution106 {
    private Map<Integer, Integer> indMap = null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        indMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            indMap.put(inorder[i],i);
        }
        return buildTree(postorder,len-1,0,len);
    }

    private TreeNode buildTree(int[] postorder, int i, int start, int end) {
        if (start >= end || i < 0) return null;
        int val = postorder[i];
        int ind = indMap.get(val);
        int dis = end - ind - 1;
        TreeNode node = new TreeNode(val);
        node.right = buildTree(postorder,i-1,ind+1,end);
        node.left = buildTree(postorder,i-dis-1,start,ind);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
