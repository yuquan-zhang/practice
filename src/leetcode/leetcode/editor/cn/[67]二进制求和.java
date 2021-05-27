package leetcode.leetcode.editor.cn;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 613 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution67 {
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int i = 1;
        StringBuilder ans = new StringBuilder();
        boolean carried = false;
        while (al - i >= 0 && bl - i >= 0) {
            char ac = a.charAt(al - i);
            char bc = b.charAt(bl - i);
            if (carried) {
                if (ac == '0' && bc == '0') {
                    carried = false;
                    ans.append('1');
                } else if (ac == '1' && bc == '1') {
                    ans.append('1');
                } else {
                    ans.append('0');
                }
            } else {
                if (ac == '1' && bc == '1') {
                    carried = true;
                    ans.append('0');
                } else if (ac == '0' && bc == '0') {
                    ans.append('0');
                } else {
                    ans.append('1');
                }
            }
            i++;
        }
        if (al < bl) {
            al = bl;
            a = b;
        }
        while (al - i >= 0) {
            char ac = a.charAt(al - i);
            if (carried) {
                if (ac == '1') {
                    ans.append('0');
                } else {
                    carried = false;
                    ans.append('1');
                }
            } else {
                ans.append(ac);
            }
            i++;
        }
        if (carried) ans.append('1');
        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
