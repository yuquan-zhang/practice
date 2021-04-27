package leetcode.leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1263 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    private final Map<Character, String> numToCharMap = new HashMap<>();
    {
        numToCharMap.put('2',"abc");
        numToCharMap.put('3',"def");
        numToCharMap.put('4',"ghi");
        numToCharMap.put('5',"jkl");
        numToCharMap.put('6',"mno");
        numToCharMap.put('7',"pqrs");
        numToCharMap.put('8',"tuv");
        numToCharMap.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        joinLetters(ans, digits, 0, "");
        return ans;
    }

    private void joinLetters(List<String> ans, String digits, int i, String s) {
        if (i >= digits.length()) return;
        String letters = numToCharMap.get(digits.charAt(i));
        if (i == digits.length() - 1) {
            for (Character c : letters.toCharArray()) {
                ans.add(s + c);
            }
        } else {
            for (Character c : letters.toCharArray()) {
                joinLetters(ans,digits,i+1, s+c);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
