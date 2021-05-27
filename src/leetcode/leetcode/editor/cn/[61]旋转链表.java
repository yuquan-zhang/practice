package leetcode.leetcode.editor.cn;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 568 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int n = 0;
        ListNode tn = head;
        ListNode tail = head;
        while (tn != null) {
            n++;
            if (tn.next == null) {
                tail = tn;
            }
            tn = tn.next;

        }
        k = n - (k % n);
        if (k == n) return head;
        tail.next = head;
        while (k-- > 0) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)