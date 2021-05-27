package leetcode.leetcode.editor.cn;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 944 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            if (pre[1] >= cur[0] && pre[0] <= cur[1]) {
                if (cur[0] < pre[0]) pre[0] = cur[0];
                if (pre[1] < cur[1]) pre[1] = cur[1];
            } else {
                ans.add(Arrays.asList(pre[0],pre[1]));
                pre = intervals[i];
            }
        }
        ans.add(Arrays.asList(pre[0],pre[1]));
        int size = ans.size();
        int[][] ret = new int[size][2];
        for (int i = 0; i < size; i++) {
            List<Integer> list = ans.get(i);
            int[] ints = new int[2];
            ints[0] = list.get(0);
            ints[1] = list.get(1);
            ret[i] = ints;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
