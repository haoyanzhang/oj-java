package com.zhy.leetcode.problem.uniquebinarysearchtrees;


class Solution {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = 1; j <= i; j++) {
                result += dp[j-1] * dp[i-j];
            }
            dp[i] = result;
        }
        return dp[n];
    }
}