package com.zhy.leetcode.problem.splitarraylargestsum;

import java.util.Arrays;

class Solution {

    public int splitArray(int[] nums, int m) {

        int[][] dp = new int[m][nums.length];

        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
        }
        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < nums.length; j++) {
                int sum = 0;
                for (int k = j; k >= i; k--) {
                    sum += nums[k];
                    if (sum > dp[i][j] ) {
                        break;
                    }
                    dp[i][j] = Math.min(Math.max(sum, dp[i - 1][k - 1]), dp[i][j]);
                }
            }
        }
        return dp[m-1][dp[m-1].length - 1];
    }
}
