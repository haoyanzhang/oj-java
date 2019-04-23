package com.zhy.leetcode.problem.jumpgameII;

import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] + j >= i && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
