package com.zhy.leetcode.problem.besttimetobuyandsellstockIII;

/**
 * @author zhanghaoyan
 */
class Solution {


    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];

        dp1[0] = dp2[prices.length - 1] = 0;
        int min1 = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min1;
            dp1[i] = Math.max(profit, dp1[i-1]);
            min1 = Math.min(min1, prices[i]);
        }
        int max2 = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            int profit = max2 - prices[i];
            dp2[i] = Math.max(profit, dp2[i+1]);
            max2 = Math.max(max2, prices[i]);
        }

        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, dp1[i] + dp2[i]);
        }
        return res;
    }
}
