package leetcode.leetcode.editor.cn;
//编写一个程序，通过填充空格来解决数独问题。
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 哈希表 回溯算法 
// 👍 834 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution37 {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sqr = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int k = ch - 49;
                    row[i][k] = true;
                    col[j][k] = true;
                    int si = i / 3 + j / 3 * 3;
                    sqr[si][k] = true;
                }
            }
        }
        solveSudoku(board, row, col, sqr, 0, 0);
    }

    private boolean solveSudoku(char[][] board, boolean[][] row, boolean[][] col,
                             boolean[][] sqr, int i, int j) {
        if (i >= 9 && j >= 8) return true;
        if (i >= 9) {
            i = 0;
            j++;
        }
        if (board[i][j] != '.') {
            return solveSudoku(board, row, col, sqr, i+1, j);
        }
        int k = i / 3 + j / 3 * 3;
        for (int n = 0; n < 9; n++) {
            if (row[i][n]) continue;
            if (col[j][n]) continue;
            if (sqr[k][n]) continue;
            board[i][j] = (char)(n + 49);
            row[i][n] = true;
            col[j][n] = true;
            sqr[k][n] = true;
            boolean bool = solveSudoku(board, row, col, sqr, i+1, j);
            if (bool) return true;
            board[i][j] = '.';
            row[i][n] = false;
            col[j][n] = false;
            sqr[k][n] = false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
