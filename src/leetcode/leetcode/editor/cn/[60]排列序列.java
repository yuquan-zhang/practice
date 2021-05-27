package leetcode.leetcode.editor.cn;
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution60 {
    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n];
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int fac = factorial(n);
            int i = (k - 1) / fac;
            k = k - (i * fac);
            int j = 0;
            while (i >= 0) {
                if (vis[j++]) {
                    continue;
                }
                i--;
            }
            j--;
            sb.append((char)(j + '1'));
            vis[j] = true;
        }
        return sb.toString();
    }

    private int factorial(int n) {
        int ans = 1;
        while (n > 1) {
            ans *= n--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
