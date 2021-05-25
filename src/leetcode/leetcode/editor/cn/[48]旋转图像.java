package leetcode.leetcode.editor.cn;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 884 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int li = n / 2;
        int lj = n % 2 == 0 ? li : li + 1;
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < lj; j++) {
                int ci = i, cj = j;
                int temp = matrix[ci][cj];
                int k = 3;
                while (k-- > 0) {
                    int tj = n - 1 - ci;
                    int ti = cj;
                    int next = matrix[ti][tj];
                    matrix[ti][tj] = temp;
                    temp = next;
                    ci = ti;
                    cj = tj;
                }
                matrix[i][j] = temp;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
