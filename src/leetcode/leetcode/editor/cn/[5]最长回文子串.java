package leetcode.leetcode.editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() < 2) return s;
        int start = 0, end = 1;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            int len1 = maxPalindromeLen(s, i, i);
            int len2 = maxPalindromeLen(s, i, i+1);
            int maxLen = Math.max(len1,len2);
            if (maxLen > end - start) {
                start = i - (maxLen-1)/2;
                end = start + maxLen;
            }
        }
        return s.substring(start, end);
    }

    private int maxPalindromeLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
            left--;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("ac"));
        System.out.println(new Solution().longestPalindrome("aaaa"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
