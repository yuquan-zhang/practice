package leetcode.leetcode.editor.cn;
//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution97 {
    boolean[][] memo = null;
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 == 0 && l2 == 0 && l3 == 0) return true;
        if (l1 + l2 != l3) return false;
        memo = new boolean[l1 + 1][l2 + 1];
        memo[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            memo[i][0] = memo[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j = 1; j <= l2; j++) {
            memo[0][j] = memo[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                memo[i][j] = (memo[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j - 1))
                        || (memo[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j - 1));
            }
        }
        return memo[l1][l2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
