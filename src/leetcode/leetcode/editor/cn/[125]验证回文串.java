package leetcode.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return true;
        s = s.toLowerCase();
        int li = 0, ri = len - 1;
        while (li <= ri) {
            if (isLetterOrNum(s.charAt(li))) {
                li++;
                continue;
            }
            if (isLetterOrNum(s.charAt(ri))) {
                ri--;
                continue;
            }
            if (s.charAt(li) != s.charAt(ri)) return false;
            li++;
            ri--;
        }
        return true;
    }

    private boolean isLetterOrNum(char ch) {
        return (ch < '0' || ch > '9') && (ch < 'a' || ch > 'z');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
