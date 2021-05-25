package leetcode.leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 649 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {
    public double myPow(double x, int n) {
        if (x == 1) return x;
        if (x == 0) return 0;
        if (n == -1) return 1/x;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            double ans = 1;
            double tem = 1/x;
            int k = -1;
            while (true) {
                while (n - k <= k) {
                    tem *= tem;
                    k += k;
                }
                if (k == n) break;
                n = n - k;
                k = -1;
                ans *= tem;
                tem = 1/x;
            }
            ans *= tem;
            return ans;
        }
        double ans = 1;
        double tem = x;
        int k = 1;
        while (true) {
            while (n - k >= k) {
                tem *= tem;
                k += k;
            }
            if (k == n) break;
            n = n - k;
            k = 1;
            ans *= tem;
            tem = x;
        }
        ans *= tem;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
