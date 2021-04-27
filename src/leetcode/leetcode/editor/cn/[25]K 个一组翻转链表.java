package leetcode.leetcode.editor.cn;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1065 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode th = head;
        int n = 0;
        while (th != null) {
            n++;
            th = th.next;
        }
        int len = n / k;
        ListNode tail = head;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                head = reverse(head, k, null);
            } else {
                tail = reverse(tail.next, k, tail);
            }
        }
        return head;
    }

    private ListNode reverse(ListNode head, int k, ListNode pre) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode temp = head;
        ListNode newTail = head;
        head = head.next;
        temp.next = null;
        ListNode tail = head.next;
        head.next = temp;
        temp = head;
        k-=2;
        while (tail != null && k > 0) {
            head = tail;
            tail = head.next;
            head.next = temp;
            temp = head;
            k--;
        }
        newTail.next = tail;
        if (pre != null) {
            pre.next = head;
        }
        return null == pre ? head : newTail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
