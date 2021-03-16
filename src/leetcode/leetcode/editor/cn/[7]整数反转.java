package leetcode.leetcode.editor.cn;//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2603 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean isMinus = x < 0;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i > 0; i--) {
            sb.append(chars[i]);
        }
        if (isMinus) {
            sb.insert(0, "-");
        } else {
            sb.append(chars[0]);
        }
        if (isMinus && sb.length() >= 11) {
            if (String.valueOf(Integer.MIN_VALUE).compareTo(sb.toString()) < 0) {
                return 0;
            }
        }
        if (!isMinus && sb.length() >= 10) {
            if (String.valueOf(Integer.MAX_VALUE).compareTo(sb.toString()) < 0) {
                return 0;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1234));
        System.out.println(new Solution().reverse(-1234));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
