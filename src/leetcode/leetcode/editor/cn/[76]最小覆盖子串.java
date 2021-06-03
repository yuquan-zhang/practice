package leetcode.leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1176 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tm = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer c = tm.computeIfAbsent(ch, k -> 0);
            tm.put(ch, c+1);
        }
        Map<Character, Integer> cm = new HashMap<>();
        int lw = 0, rw = 0;
        int len = s.length();
        int tl = 0, tr = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!tm.containsKey(ch)) {
                rw++;
                continue;
            }
            int c = cm.computeIfAbsent(ch, k -> 0);
            cm.put(ch, c+1);
            int tc = tm.getOrDefault(ch, 0);
            if (tc == c + 1)  {
                boolean flag = false;
                while (flag || match(cm, tm)) {
                    if (tr - tl == 0 || rw - lw < tr - tl) {
                        tl = lw;
                        tr = rw + 1;
                    }
                    char lch = s.charAt(lw);
                    int lc = cm.getOrDefault(lch, 0);
                    int tv = tm.getOrDefault(lch, 0);
                    if (lc > 1) {
                        cm.put(lch, lc - 1);
                    } else {
                        cm.remove(lch);
                    }
                    lw++;
                    flag = tv == 0 || lc > tv;
                }
            }
            rw++;
        }

        return s.substring(tl, tr);
    }

    private boolean match(Map<Character, Integer> cm, Map<Character, Integer> tm) {
        if (cm.size() < tm.size()) return false;
        for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
            Integer c = cm.get(entry.getKey());
            if (c == null || c < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
