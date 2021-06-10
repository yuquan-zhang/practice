package leetcode.leetcode.editor.cn;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 797 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer,Integer> smallToBig = new HashMap<>();
        Map<Integer,Integer> bigToSmall = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int ans = 1;
        for (int n : nums) {
            if (set.contains(n)) continue;
            set.add(n);
            boolean sb = smallToBig.containsKey(n+1);
            boolean bs = bigToSmall.containsKey(n-1);
            if (sb && bs) {
                int lv = bigToSmall.remove(n-1);
                int rv = smallToBig.remove(n+1);
                ans = Math.max(ans, rv - lv + 1);
                smallToBig.put(lv,rv);
                bigToSmall.put(rv,lv);
            } else if (sb) {
                int val = smallToBig.remove(n+1);
                ans = Math.max(ans, val - n + 1);
                smallToBig.put(n,val);
                bigToSmall.put(val,n);
            } else if (bs) {
                int val = bigToSmall.remove(n-1);
                ans = Math.max(ans, n - val + 1);
                bigToSmall.put(n,val);
                smallToBig.put(val,n);
            } else {
                smallToBig.put(n,n);
                bigToSmall.put(n,n);
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
