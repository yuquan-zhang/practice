package leetcode.leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 434 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution132 {
    public int minCut(String s) {
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
        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            if (isPa[0][i]) {
                ans[i] = 0;
            } else {
                ans[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    if (isPa[j][i]) {
                        ans[i] = Math.min(ans[i],ans[j-1] + 1);
                    }
                }
            }
        }
        return ans[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
