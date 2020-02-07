package com.zhy.leetcode.problem.bestimetobuyandsellstockwithcooldown;



class Solution {


    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        int[] coolDown = new int[prices.length];

        hold[0] = -prices[0];
        sold[0] = 0;
        coolDown[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1], sold[i-1] - prices[i]);
            coolDown[i] = hold[i-1] + prices[i];
            sold[i] = Math.max(coolDown[i-1], sold[i-1]);
        }

        return Math.max(sold[sold.length-1], coolDown[sold.length-1]);
    }

}