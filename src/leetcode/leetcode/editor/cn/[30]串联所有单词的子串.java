package leetcode.leetcode.editor.cn;
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 463 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || words[0].length() == 0
                || s.length() < words.length * words[0].length()) return ans;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.merge(word, 1, Integer::sum);
        }
        int wl = words[0].length();
        int tl = wl * words.length;
        for (int i = 0, len = s.length() - tl; i <= len; i++) {
            String subStr = s.substring(i, i+wl);
            if (wordMap.containsKey(subStr)) {
                Map<String, Integer> copy = new HashMap<>(wordMap);
                Integer num = copy.get(subStr);
                if (num > 1) {
                    copy.put(subStr, num - 1);
                } else {
                    copy.remove(subStr);
                }
                find(copy, s, i, i+wl, wl, ans);
            }
        }
        return ans;
    }

    private void find(Map<String, Integer> wordMap, String s, int start, int i, int wl, List<Integer> ans) {
        if (wordMap.size() == 0) {
            ans.add(start);
            return;
        }
        if (i + wl > s.length()) return;
        String subStr = s.substring(i, i+wl);
        if (wordMap.containsKey(subStr)) {
            Integer num = wordMap.get(subStr);
            if (num > 1) {
                wordMap.put(subStr, num - 1);
            } else {
                wordMap.remove(subStr);
            }
            find(wordMap, s, start,i+wl, wl, ans);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
