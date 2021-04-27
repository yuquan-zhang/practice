package leetcode.leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1721 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<>();
        if (n == 1) return Collections.singletonList("()");
        Set<String> ans = new HashSet<>();
        gen(ans, n, "(", 1, 0);
        return new ArrayList<>(ans);
    }
    private void gen(Set<String> ans, int n, String pre, int lp, int rp) {
        if (lp >= n && rp >= n) {
            ans.add(pre);
            return;
        }
        if (lp < n && lp >= rp) {
            gen(ans, n, pre + "(", lp+1, rp);
        }
        if (rp < n && rp < lp) {
            gen(ans, n, pre + ")", lp, rp+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
