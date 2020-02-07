package com.zhy.leetcode.problem.maximalsquare;

class Solution {

    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == '1'? 1: 0;
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1'? 1: 0;
            max = Math.max(max, dp[0][i]);
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = matrix[i][j] == '1'? Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1: 0;
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
