package com.zhy.leetcode.problem.burstballoons;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                int last = i + len - 1;
                dp[i][last] = 0;
                for (int j = 0; j < len; j++) {
                    int cur = i + j;
                    int i1 = i <= cur - 1? dp[i][cur - 1]: 0;
                    int i2 = cur + 1 <= last? dp[cur + 1][last]: 0;
                    int num1 = i - 1 >= 0? nums[i - 1]: 1;
                    int num2 = last + 1 < nums.length? nums[last + 1]: 1;
                    dp[i][last] = Math.max(dp[i][last], i1 + i2 + num1 * nums[cur] * num2);
                }
            }
        }
        return dp[0][nums.length - 1];
    }


}
