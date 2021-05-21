package leetcode.leetcode.editor.cn;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 575 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution40 {

    private final Set<String> ansSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        ansSet.clear();
        combinationSumInner(ans, new ArrayList<>(),"",-1, candidates, target);
        return ans;
    }

    private void combinationSumInner(List<List<Integer>> ans, List<Integer> ints, String s, int last, int[] candidates, int target) {
        if (target < 0) return;
        if (target == 0) {
            if (ints.size() > 0 && !ansSet.contains(s)) {
                ans.add(ints);
                ansSet.add(s);
            }
            return;
        }
        int l = ints.size() > 0 ? ints.get(ints.size() - 1) : -1;
        for (int i = last + 1; i < candidates.length; i++) {
            int c = candidates[i];
            if (target < c) break;
            if (i > 0 && candidates[i] == candidates[i-1] && l != c) continue;
            List<Integer> res = new ArrayList<>(ints);
            res.add(c);
            combinationSumInner(ans,res,s + c,i,candidates,target-c);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(new Solution40().combinationSum2(ints,27));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
