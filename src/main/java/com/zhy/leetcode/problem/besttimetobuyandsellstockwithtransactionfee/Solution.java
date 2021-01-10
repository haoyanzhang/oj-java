package com.zhy.leetcode.problem.besttimetobuyandsellstockwithtransactionfee;

class Solution {


    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];


        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {

            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);

        }

        return sell[sell.length - 1];
    }

}
