package leetcode.leetcode.editor.cn;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 505 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(Collections.singletonList(1));
        if (numRows == 1) return ans;
        ans.add(new ArrayList<>(Arrays.asList(1,1)));
        if (numRows == 2) return ans;
        int i = 3;
        List<Integer> pre = ans.get(1);
        while (i <= numRows) {
            int k = 0;
            List<Integer> cur = new ArrayList<>();
            while (k < i) {
                if (k == 0 || k == i - 1) cur.add(1);
                else cur.add(pre.get(k) + pre.get(k-1));
                k++;
            }
            ans.add(cur);
            pre = cur;
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
