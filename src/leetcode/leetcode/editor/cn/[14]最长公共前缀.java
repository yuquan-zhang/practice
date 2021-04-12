package leetcode.leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1558 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder maxPre = new StringBuilder();
        if (strs == null || strs.length == 0) return "";
        int i = 0;
        boolean loop = true;
        while (loop) {
            Character c = null;
            for (String s : strs) {
                if (s.length() <= i) {
                    loop = false;
                    break;
                }
                if (c == null) c = s.charAt(i);
                if (!c.equals(s.charAt(i))) {
                    loop = false;
                    break;
                }
            }
            if (loop) maxPre.append(c);
            i++;
        }
        return maxPre.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
