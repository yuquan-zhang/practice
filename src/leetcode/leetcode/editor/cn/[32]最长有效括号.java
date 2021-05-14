package leetcode.leetcode.editor.cn;
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1289 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!charStack.isEmpty() && '(' == charStack.peek() && ')' == s.charAt(i)) {
                charStack.pop();
                indexStack.pop();
            } else {
                charStack.push(s.charAt(i));
                indexStack.push(i);
            }
        }
        if (indexStack.isEmpty()) return len;
        int start = indexStack.pop();
        int ans = len - 1 - start;
        while (!indexStack.isEmpty()) {
            len = start;
            start = indexStack.pop();
            ans = Math.max(ans, len - 1 - start);
        }
        ans = Math.max(ans, start);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
