package leetcode.leetcode.editor.cn;
//使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
// 
// 如果字符串的长度为 1 ，算法停止 
// 如果字符串的长度 > 1 ，执行下述步骤：
// 
// 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。 
// 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x
// 。 
// 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。 
// 
// 
// 
//
// 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "great", s2 = "rgeat"
//输出：true
//解释：s1 上可能发生的一种情形是：
//"great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
//"gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
//"gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
//"g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
//"r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
//"r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
//算法终止，结果字符串和 s2 相同，都是 "rgeat"
//这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abcde", s2 = "caebd"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "a", s2 = "a"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// s1.length == s2.length 
// 1 <= s1.length <= 30 
// s1 和 s2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 378 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution87 {
    private int[][][] memo = null;
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        memo = new int[n][n][n+1];
        return scramble(0,s1,0,s2, n);
    }

    private boolean scramble(int i1, String s1, int i2, String s2, int n) {
        if (memo[i1][i2][n] != 0) {
            return memo[i1][i2][n] == 1;
        }
        String sub1 = s1.substring(i1, i1 + n);
        String sub2 = s2.substring(i2, i2 + n);
        if (sub1.equals(sub2)) {
            memo[i1][i2][n] = 1;
            return true;
        }
        if (!hasSameLetters(sub1, sub2, n)) {
            memo[i1][i2][n] = -1;
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (scramble(i1, s1, i2, s2, i) && scramble(i1+i, s1, i2+i, s2, n - i)) {
                memo[i1][i2][n] = 1;
                return true;
            }
            if (scramble(i1, s1, i2 + n - i, s2, i) && scramble(i1+i, s1, i2, s2, n - i)) {
                memo[i1][i2][n] = 1;
                return true;
            }
        }
        memo[i1][i2][n] = -1;
        return false;
    }

    private boolean hasSameLetters(String sub1, String sub2, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = sub1.charAt(i);
            Integer count = map.computeIfAbsent(ch, k -> 0);
            map.put(ch, count+1);
            char ch2 = sub2.charAt(i);
            Integer count2 = map.computeIfAbsent(ch2, k -> 0);
            map.put(ch2,count2-1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }

    private Set<String> scramble(String s) {
        if (s.length() == 1) return Collections.singleton(s);
        Set<String> set = new HashSet<>();
        for (int i = 1, len = s.length(); i < len; i++) {
            Set<String> pre = scramble(s.substring(0, i));
            Set<String> suf = scramble(s.substring(i, len));
            for (String ps : pre) {
                for (String ss : suf) {
                    set.add(ps + ss);
                    set.add(ss + ps);
                }
            }
        }
        return set;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
