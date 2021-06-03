package leetcode.leetcode.editor.cn;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1381 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] lb = new int[n];
        int[] rb = new int[n];
        Arrays.fill(rb,n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rb[stack.pop()] = i;
            }
            lb[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for(int i = 0; i < n; i++) {
            max = Math.max(max,(rb[i] - lb[i] - 1) * heights[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
