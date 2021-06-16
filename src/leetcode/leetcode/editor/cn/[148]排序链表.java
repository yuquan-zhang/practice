package leetcode.leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1178 👎 0


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
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) {
            if (head.val < head.next.val) return head;
            else {
                ListNode ans = head.next;
                ans.next = head;
                head.next = null;
                return ans;
            }
        }
        ListNode left = null;
        ListNode right = null;
        ListNode tn = head;
        int k = 0;
        while (tn != null) {
            ListNode next = tn.next;
            if (k == 0) {
                if (left == null) {
                    left = tn;
                    left.next = null;
                } else {
                    tn.next = left;
                    left = tn;
                }
                k = 1;
            } else {
                if (right == null) {
                    right = tn;
                    right.next = null;
                } else {
                    tn.next = right;
                    right = tn;
                }
                k = 0;
            }
            tn = next;
        }
        left = sortList(left);
        right = sortList(right);
        ListNode ans = null;
        ListNode ta = null;
        while (left != null && right != null) {
            ListNode next = null;
            if (left.val < right.val) {
                next = left;
                left = left.next;
            } else {
                next = right;
                right = right.next;
            }
            if (ans == null) {
                ans = next;
                ta = ans;
            } else {
                ta.next = next;
                ta = next;
            }
        }
        if (left != null) {
            ta.next = left;
        }
        if (right != null) {
            ta.next = right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
