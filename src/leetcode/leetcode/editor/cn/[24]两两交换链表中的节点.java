package leetcode.leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 896 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 0) return null;
        if (list.size() > 1) {
            for (int i = 0; i < list.size() / 2; i++) {
                ListNode temp = list.get(i*2);
                list.set(i*2,list.get(i*2+1));
                list.set(i*2+1,temp);
                list.get(i*2).next = list.get(i*2+1);
                if (i*2+2 == list.size() - 1) {
                    list.get(i*2+1).next = list.get(i*2+2);
                }
                if (i > 0) {
                    list.get(i*2-1).next = list.get(i*2);
                }
            }
            list.get(list.size() - 1).next = null;
        }
        return list.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
