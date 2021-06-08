package leetcode.leetcode.editor.cn;
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 293 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex == -1) return ans;
        ans = Collections.singletonList(1);
        if(rowIndex == 0) return ans;
        ans = new ArrayList<>(Arrays.asList(1,1));
        if(rowIndex == 1) return ans;
        List<Integer> pre = ans;
        int i = 2;
        while (i <= rowIndex) {
            int k = 0;
            ans = new ArrayList<>();
            while (k < i+1) {
                if (k == 0 || k == i) ans.add(1);
                else ans.add(pre.get(k) + pre.get(k-1));
                k++;
            }
            pre = ans;
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
