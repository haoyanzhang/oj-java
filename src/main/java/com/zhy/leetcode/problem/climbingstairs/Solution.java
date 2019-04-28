package com.zhy.leetcode.problem.climbingstairs;

class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n > 2 ? n : 2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
}
