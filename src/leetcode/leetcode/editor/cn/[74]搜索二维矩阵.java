package leetcode.leetcode.editor.cn;
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0, e = m * n - 1;
        int mid = (s + e) / 2;
        int pre = -1, i = -1, j = -1;
        while (mid != pre) {
            i = mid / n;
            j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                s = mid;
            } else {
                e = mid;
            }
            pre = mid;
            mid = (s + e) / 2;
        }
        if (mid == s) {
            if (j+1 < n) {
                if (matrix[i][j+1] == target) return true;
            } else if (i+1 < m){
                if (matrix[i+1][0] == target) return true;
            }
        }
        if (mid == e) {
            if (j > 0) {
                return matrix[i][j - 1] == target;
            } else if (i > 0){
                return matrix[i - 1][0] == target;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
