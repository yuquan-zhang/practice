package leetcode.leetcode.editor.cn;
//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 582 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIp(ans, s, 0, 4, "");
        return ans;
    }

    private void restoreIp(List<String> ans, String s, int i, int k, String pre) {
        if (k == 0) {
            if (i == s.length()) ans.add(pre);
        } else if (k > 0) {
            for (int j = i + 1; j <= s.length() && j < i + 4; j++) {
                if (isValidIp(s, i, j)) {
                    String cur = pre;
                    if (cur.length() > 0) cur += ".";
                    cur += s.substring(i,j);
                    restoreIp(ans,s,j,k-1,cur);
                }
            }
        }
    }

    private boolean isValidIp(String s, int start, int end) {
        int len = end - start;
        if (len - start > 3) return false;
        if (s.charAt(start) == '0') return len == 1;
        if (s.charAt(start) == '1') return true;
        if (len < 3) return true;
        if (s.charAt(start) > '2') return false;
        if (s.charAt(start + 1) < '5') return true;
        if (s.charAt(start + 1) > '5') return false;
        return s.charAt(start + 2) < '6';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
