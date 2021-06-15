package leetcode.leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 465 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution140 {
    private Set<String> wordSet = null;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        String[][] flags = new String[len+1][len+1];
        List<String> ans = new ArrayList<>();
        wordSet = new HashSet<>(wordDict);
        Stack<String> stack = new Stack<>();
        wordBreak(ans,s,0,flags,stack);
        return ans;
    }

    private void wordBreak(List<String> ans, String s, int i, String[][] flags, Stack<String> stack) {
        if (i == s.length()) {
            StringBuilder sb = new StringBuilder();
            stack.forEach(word -> {
                if (sb.length() > 0) sb.append(" ");
                sb.append(word);
            });
            ans.add(sb.toString());
        } else {
            for (int j = i + 1; j <= s.length(); j++) {
                if (flags[i][j] == null) {
                    String sub = s.substring(i,j);
                    if (wordSet.contains(sub)) {
                        flags[i][j] = sub;
                    } else {
                        flags[i][j] = "";
                        continue;
                    }
                } else if (flags[i][j].length() == 0) {
                    continue;
                }
                stack.add(flags[i][j]);
                wordBreak(ans,s,j,flags,stack);
                stack.pop();
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)