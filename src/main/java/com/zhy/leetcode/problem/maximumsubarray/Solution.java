package com.zhy.leetcode.problem.maximumsubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            int t = dp[i - 1] + nums[i];
            dp[i] = t > nums[i] ? t : nums[i];
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
