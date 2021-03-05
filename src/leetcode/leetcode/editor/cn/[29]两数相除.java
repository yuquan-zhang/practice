package leetcode.leetcode.editor.cn;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 465 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (Integer.MIN_VALUE == dividend) return Integer.MAX_VALUE;
            return -dividend;
        }
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) {
             return 0;
        }
        boolean hasPlus = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend += 1;
            hasPlus = true;
        }
        boolean isMinus = false;
        if (dividend < 0) {
            isMinus = true;
            dividend = -dividend;
        }
        if (divisor < 0) {
            isMinus = !isMinus;
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend >= divisor) {
            int divisor2 = divisor;
            int p = 1;
            while (dividend >= divisor2) {
                if (divisor2 < 0) break;
                ans += p;
                dividend -= divisor2;
                divisor2 += divisor2;
                p += p;
            }
        }
        if (hasPlus) {
            ans += (dividend + 1) / divisor;
        }
        return isMinus ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, -1));
        System.out.println(new Solution29().divide(Integer.MAX_VALUE, -1));
        System.out.println(new Solution29().divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(new Solution29().divide(-99, 3));
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
