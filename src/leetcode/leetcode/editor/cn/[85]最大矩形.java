package leetcode.leetcode.editor.cn;
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 934 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (cols == 0) return 0;
        int[][] left1 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left1[i][j] = (j == 0 ? 0 : left1[i][j-1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < cols; j++) {
            int[] lb = new int[rows];
            int[] rb = new int[rows];
            Arrays.fill(rb,rows);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left1[stack.peek()][j] > left1[i][j]) {
                    rb[stack.pop()] = i;
                }
                lb[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < rows; i++) {
                int area = (rb[i] - lb[i] - 1) * left1[i][j];
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
