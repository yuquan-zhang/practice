package leetcode.leetcode.editor.cn;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 596 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.Stack;

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
class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode tn = head;
        while (tn != null) {
            stack.push(tn);
            tn = tn.next;
        }
        tn = head;
        while (!tn.equals(stack.peek()) && !stack.peek().equals(tn.next)) {
            ListNode next = tn.next;
            tn.next = stack.pop();
            tn.next.next = next;
            tn = next;
        }
        if (tn.equals(stack.peek())) {
            tn.next = null;
        } else {
            tn.next.next = null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
