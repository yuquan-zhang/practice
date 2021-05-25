package leetcode.leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 784 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0, sum = m * n;
        int lu = 1, ru = n - 1, rd = m - 1, ld = 0;
        int dir = 0;
        List<Integer> ans = new ArrayList<>();
        while (sum-- > 0) {
            ans.add(matrix[i][j]);
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
