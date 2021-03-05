package leetcode.leetcode.editor.cn;//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 636 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution28 {

    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (nl == 0) return 0;
        if (nl > hl) return -1;
        long pre = hash(haystack, 0, nl);
        long needleHash = hash(needle, 0, nl);
        if (needleHash == pre) {
            if (isSameStr(needle,haystack,0)) return 0;
        }
        for (int i = 1; i < hl - nl + 1; i++) {
            pre = pre + haystack.charAt(i + nl - 1) - haystack.charAt(i - 1);
            if (needleHash == pre && isSameStr(needle,haystack, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSameStr(String s1, String s2, int hi) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i + hi)) return false;
        }
        return true;
    }

    private long hash(String master, int startIndex, int endIndex) {
        long ans = 0;
        for (int i = startIndex; i < endIndex; i++) {
            ans += master.charAt(i);
        }
        return ans;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution28().strStr("hello","ll"));
//        System.out.println(new Solution28().strStr("aaaaa",""));
//        System.out.println(new Solution28().strStr("a","a"));
//        System.out.println(new Solution28().strStr("abc","c"));
//        StringBuilder master = new StringBuilder();
//        for (int i = 0; i < 10000; i++) {
//            for (int j = 0; j < 10000; j++) {
//                master.append("bc");
//            }
//
//        }
//        StringBuilder pattern = new StringBuilder();
//        for (int i = 0; i < 10000; i++) {
//            pattern.append("ad");
//        }
//        long start = System.currentTimeMillis();
//        System.out.println(new Solution28().strStr(master.toString(),pattern.toString()));
//        System.out.println("耗时：" + (System.currentTimeMillis() - start));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
