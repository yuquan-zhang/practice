package leetcode.leetcode.editor.cn;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 790 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution123 {
    private int max = 0;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int b1 = -prices[0], s1 = 0;
        int b2 = -prices[0], s2 = 0;
        for (int i = 1; i < len; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1,b1 + prices[i]);
            b2 = Math.max(b2,s1 - prices[i]);
            s2 = Math.max(s2,b2 + prices[i]);
        }
        return s2;
    }

    private void maxProfit(int[] prices, int li, int ri, int sum, int t) {
        if (ri >= prices.length) {
            max = Math.max(max, sum);
            return;
        }
        if (t < 0) return;
        if (t == 0) {
            max = Math.max(max, sum);
            return;
        }
        if (prices[ri] > prices[li]) {
            maxProfit(prices,ri+1,ri+2,sum + (prices[ri] - prices[li]),t-1);
            maxProfit(prices,li, ri+1,sum,t);
        } else {
            maxProfit(prices,ri,ri+1,sum,t);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
