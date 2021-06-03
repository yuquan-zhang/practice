package leetcode.leetcode.editor.cn;
//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。 
//
// 格雷编码序列必须以 0 开头。 
//
// 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1 
//
// 示例 2: 
//
// 输入: 0
//输出: [0]
//解释: 我们定义格雷编码序列必须以 0 开头。
//     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//     因此，当 n = 0 时，其格雷编码序列为 [0]。
// 
// Related Topics 回溯算法 
// 👍 297 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution89 {
    public List<Integer> grayCode(int n) {
        if (n == 0) return Collections.singletonList(0);
        if (n == 1) return new ArrayList<>(Arrays.asList(0,1));
        List<Integer> ans = grayCode(n - 1);
        int add = (int)Math.pow(2, n - 1);
        for (int i = ans.size() - 1; i >= 0; i--) {
            ans.add(ans.get(i) | add);
        }
        return ans;
    }

    public int twoPow(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        int ans = 1;
        int tem = 2;
        int k = 1;
        while (true) {
            while (n - k >= k) {
                tem *= tem;
                k += k;
            }
            if (k == n) break;
            n = n - k;
            k = 1;
            ans *= tem;
            tem = 2;
        }
        ans *= tem;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
