package leetcode.leetcode.editor.cn;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 261 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution52 {

    private final Set<Integer> columns = new HashSet<>();
    private final Set<Integer> diagonal1 = new HashSet<>();
    private final Set<Integer> diagonal2 = new HashSet<>();
    private Integer ans = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        ans = 0;
        solveNQueens(n, board, 0);
        return ans;
    }


    private void solveNQueens(int n, char[][] board, int i) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (columns.contains(j)) continue;
            if (diagonal1.contains(i + j)) continue;
            if (diagonal2.contains(i - j)) continue;
            board[i][j] = 'Q';
            columns.add(j);
            diagonal1.add(i + j);
            diagonal2.add(i - j);
            solveNQueens(n,board,i+1);
            board[i][j] = '.';
            columns.remove(j);
            diagonal1.remove(i + j);
            diagonal2.remove(i - j);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
