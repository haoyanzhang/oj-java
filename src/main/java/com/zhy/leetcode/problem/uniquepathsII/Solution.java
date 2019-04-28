package com.zhy.leetcode.problem.uniquepathsII;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j == 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[dp.length-1];
    }
}
