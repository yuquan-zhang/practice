package leetcode.leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 749 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        boolean[][] isPa = new boolean[n][n];
        int k = 1;
        while (k <= n) {
            int m = n - k;
            for (int i = 0; i <= m; i++) {
                int j = i+k-1;
                if (k == 1) {
                    isPa[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (k == 2 || k == 3) {
                        isPa[i][j] = b;
                    } else {
                        isPa[i][j] = isPa[i+1][j-1] && b;
                    }
                }
            }
            k++;
        }
        Stack<String> stack = new Stack<>();
        partition(ans,isPa,s,0,stack);
        return ans;
    }

    private void partition(List<List<String>> ans, boolean[][] isPa, String s, int i, Stack<String> stack) {
        if (i > s.length()) return;
        if (i == s.length()) {
            ans.add(new ArrayList<>(stack));
        } else {
            for (int k = i; k < s.length(); k++) {
                if (!isPa[i][k]) continue;
                stack.push(s.substring(i,k+1));
                partition(ans,isPa,s,k+1,stack);
                stack.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
