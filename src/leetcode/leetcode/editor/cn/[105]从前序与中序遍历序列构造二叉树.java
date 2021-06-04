package leetcode.leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1067 👎 0


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
class Solution105 {
    private Map<Integer, Integer> indMap = null;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if (len == 0) return null;
        indMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            indMap.put(inorder[i],i);
        }
        return buildTree(preorder,0,0,len);
    }

    private TreeNode buildTree(int[] preorder, int i, int start, int end) {
        if (start >= end || i >= preorder.length) return null;
        int val = preorder[i];
        int ind = indMap.get(val);
        int dis = ind - start;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(preorder,i+1,start,ind);
        node.right = buildTree(preorder,i+dis+1,ind+1,end);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
