package leetcode.leetcode.editor.cn;
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 425 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {
    public int[][] generateMatrix(int n) {
        int i = 0, j = 0, sum = n * n;
        int lu = 1, ru = n - 1, rd = n - 1, ld = 0;
        int dir = 0;
        int[][] ans = new int[n][n];
        int k = 1;
        while (k <= sum) {
            ans[i][j] = k;
            k++;
            switch (dir) {
                case 0:
                    if (j < ru) j++;
                    else {
                        i++;
                    }
                    if (j == ru) {
                        dir = 1;
                        ru--;
                    }
                    break;
                case 1:
                    if (i < rd) i++;
                    if (i == rd) {
                        dir = 2;
                        rd--;
                    }
                    break;
                case 2:
                    if (j > ld) j--;
                    if (j == ld) {
                        dir = 3;
                        ld++;
                    }
                    break;
                case 3:
                    if (i > lu) i--;
                    if (i == lu) {
                        dir = 0;
                        lu++;
                    }
                    break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
