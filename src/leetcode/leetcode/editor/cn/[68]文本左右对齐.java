package leetcode.leetcode.editor.cn;
//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 
// 👍 136 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int i = 0;
        int tm = maxWidth;
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (i < len) {
            String wd = words[i];
            if (wd.length() < tm) {
                list.add(wd);
                tm -= wd.length();
                tm--;
            } else if (wd.length() == tm) {
                list.add(wd);
                ans.add(joinStrings(list, 0, 0));
                tm = maxWidth;
                list.clear();
            } else {
                int k = tm + 1;
                int size = list.size();
                if (size == 1) {
                    ans.add(list.get(0) + fillSpace(k));
                } else {
                    int div = k / (size - 1);
                    int mod = k % (size - 1);
                    ans.add(joinStrings(list,div,mod));
                }
                tm = maxWidth;
                list.clear();
                list.add(wd);
                tm -= wd.length();
                tm--;
            }
            i++;
        }
        if (!list.isEmpty()) {
            String s = joinStrings(list,0,0);
            ans.add(s + fillSpace(maxWidth - s.length()));
        }
        return ans;
    }

    private String fillSpace(int k) {
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private String joinStrings(List<String> list, int div, int mod) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (sb.length() > 0) {
                sb.append(' ').append(fillSpace(div));
                if (mod-- > 0) sb.append(' ');
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
