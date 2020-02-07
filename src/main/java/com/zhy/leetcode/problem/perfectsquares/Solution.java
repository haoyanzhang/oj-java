package com.zhy.leetcode.problem.perfectsquares;


import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int i = 2;
        while (i <= n) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
            i++;
        }

        return dp[n];


    }

}
