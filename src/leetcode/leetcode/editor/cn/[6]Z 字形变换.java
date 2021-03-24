package leetcode.leetcode.editor.cn;//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1066 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int sLen = s.length();
        int sNum = numRows * 2 - 2;
        int totalCol = (sLen / sNum + 1) * 2;
        char[][] chars = new char[numRows][totalCol];
        int ri = 0, ci = 0, i = 0;
        boolean isUp = false;
        while (i < sLen) {
            chars[ri][ci] = s.charAt(i);
            i++;
            if (isUp) {
                ri--;
            } else {
                ri++;
            }
            if (ri == numRows) {
                isUp = true;
                ri = numRows - 2;
                ci++;
            }
            if (ri < 0) {
                isUp = false;
                ri = 1;
                ci++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int j = 0; j < totalCol; j++) {
                char c = chars[r][j];
                if (c != '\u0000') {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("PAYPALISHIRING",3));
        System.out.println(new Solution6().convert("PAYPALISHIRING",4));
        System.out.println(new Solution6().convert("ABCD",2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
