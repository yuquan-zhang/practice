package leetcode.leetcode.editor.cn;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// 👍 882 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {
    private final Set<Integer> columns = new HashSet<>();
    private final Set<Integer> diagonal1 = new HashSet<>();
    private final Set<Integer> diagonal2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(ans, n, board, 0);
        return ans;
    }

    private void solveNQueens(List<List<String>> ans, int n, char[][] board, int i) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            ans.add(list);
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
            solveNQueens(ans,n,board,i+1);
            board[i][j] = '.';
            columns.remove(j);
            diagonal1.remove(i + j);
            diagonal2.remove(i - j);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
