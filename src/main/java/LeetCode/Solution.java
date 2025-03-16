package LeetCode;

import java.util.Arrays;

/**
 * Solution 类用于计算在最多进行 k 次交易的情况下可以获得的最大利润。
 */
public class Solution {

    /**
     * 计算给定股票价格数组和最大交易次数时的最大利润。
     *
     * @param k      最大交易次数
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int n = prices.length;
        // 将 k 调整为不超过 n/2，因为最多只能进行 n/2 次交易
        k = Math.min(k, n / 2);
        // 创建 memo 数组用于存储中间结果，避免重复计算
        int[][] memo = new int[n][2 * k + 1];
        // 初始化 memo 数组，所有元素设为 -1 表示未计算的状态
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 调用深度优先搜索函数计算最大利润
        return dfs(0, 0, memo, prices, k);
    }

    /**
     * 深度优先搜索函数，递归计算从当前天开始的最大利润。
     *
     * @param depth        当前天数索引
     * @param transactions 当前已完成的交易次数（买或卖算一次）
     * @param memo         存储中间结果的二维数组
     * @param prices       股票价格数组
     * @param k            最大交易次数
     * @return 从当前天开始的最大利润
     */
    private int dfs(int depth, int transactions, int[][] memo, int[] prices, int k) {
        //还未使用交易次数或者天数为第一天时
        if (depth == prices.length || transactions == 2 * k) {
            return 0;
        }
        if (memo[depth][transactions] != -1) {
            return memo[depth][transactions];
        }
        int profit = dfs(depth + 1, transactions, memo, prices, k);
        if (transactions % 2 == 0) {
            profit = Math.max(profit, dfs(depth + 1, transactions + 1, memo, prices, k) - prices[depth]);
        } else {
            profit = Math.max(profit, dfs(depth + 1, transactions + 1, memo, prices, k) + prices[depth]);
        }
        memo[depth][transactions] = profit;
        return profit;
    }
}
