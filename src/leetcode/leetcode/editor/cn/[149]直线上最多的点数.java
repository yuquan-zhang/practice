package leetcode.leetcode.editor.cn;
//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学 
// 👍 245 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution149 {
    public int maxPoints(int[][] points) {
        int m = points.length;
        if (m <= 2) return m;
        int ans = 2;
        for (int i = 0; i < m; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                String slope = genSlope(points[i],points[j]);
                int count = slopeCount.getOrDefault(slope,1) + 1;
                ans = Math.max(ans, count);
                slopeCount.put(slope, count);
            }
        }
        return ans;
    }

    private String genSlope(int[] point, int[] point1) {
        int y = point[1] - point1[1];
        int x = point[0] - point1[0];
        int gcd = getGcd(y,x);
        y = y / gcd;
        x = x / gcd;
        return y + "/" + x;
    }

    private int getGcd(int y, int x) {
        if (x == 0) return y;
        int r = y % x;
        return getGcd(x, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
