package com.zhy.leetcode.problem.minimumpathsum;

class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j]  + grid[i][j];
                } else {
                    dp[j] = (dp[j] > dp[j - 1] ? dp[j - 1] : dp[j]) + grid[i][j];
                }
            }
        }
        return dp[dp.length - 1];
    }
}