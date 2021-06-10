package leetcode.leetcode.editor.cn;
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 549 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '+';
                checkZero(board, 1,m, j,n);
            }
            if (m > 1) {
                if (board[m-1][j] == 'O') {
                    board[m-1][j] = '+';
                    checkZero(board, m-2,m, j,n);
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '+';
                checkZero(board,i,m,1,n);
            }
            if (n > 1) {
                if (board[i][n-1] == 'O') {
                    board[i][n-1] = '+';
                    checkZero(board,i,m,n-2,n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void checkZero(char[][] board, int i, int m, int j, int n) {
        if (i >= m - 1 || j >= n - 1 || i < 1 || j < 1) return;
        if (board[i][j] == 'X') return;
        if (board[i][j] == '+') return;
        board[i][j] = '+';
        checkZero(board,i+1,m,j,n);
        checkZero(board,i-1,m,j,n);
        checkZero(board,i,m,j+1,n);
        checkZero(board,i,m,j-1,n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
