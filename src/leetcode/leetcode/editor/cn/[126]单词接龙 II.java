package leetcode.leetcode.editor.cn;
//按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s
//1 -> s2 -> ... -> sk 这样的单词序列，并满足： 
//
// 
// 
// 
// 每对相邻的单词之间仅有单个字母不同。 
// 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单
//词。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的
// 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//解释：存在 2 种最短的转换序列：
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：[]
//解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 7 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有单词 互不相同 
// 
// 
// 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 438 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;
        Map<String, List<String>> to = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();
        int wl = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        steps.put(beginWord,1);
        boolean found = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            dict.remove(cur);
            int step = steps.get(cur);
            if (to.containsKey(cur)) continue;
            to.putIfAbsent(cur,new ArrayList<>());
            char[] chars = cur.toCharArray();
            boolean isFound = false;
            for (int i = 0; i < wl; i++) {
                char origin = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == origin) continue;
                    chars[i] = ch;
                    String next = String.valueOf(chars);
                    if (!dict.contains(next)) continue;
                    if (steps.get(next) != null && step >= steps.get(next)) continue;
                    to.get(cur).add(next);
                    steps.put(next,step + 1);
                    if (next.equals(endWord)) {
                        isFound = true;
                        break;
                    }
                    queue.offer(next);
                }
                chars[i] = origin;
                if (isFound) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) return ans;
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        dfs(ans,to,stack,beginWord,endWord);
        return ans;
    }

    private void dfs(List<List<String>> ans, Map<String, List<String>> to, Stack<String> stack, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(stack));
        } else {
            List<String> list = to.getOrDefault(beginWord,new ArrayList<>());
            for (String s : list) {
                stack.push(s);
                dfs(ans,to,stack,s,endWord);
                stack.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
