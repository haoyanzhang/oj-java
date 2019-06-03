package com.zhy.leetcode.problem.editdistance;

class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0;i < word1.length() + 1; i++) {
            int last = Integer.MAX_VALUE - 1;
            for (int j = 0; j < word2.length() + 1;j ++) {
                if (j == 0) {
                    last = dp[j];
                    dp[j] = i;
                } else if (i == 0) {
                    dp[j] = j;
                } else {
                    int temp = dp[j];
                    dp[j] = min(min(dp[j - 1] + 1, dp[j] + 1), last + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
                    last = temp;
                }
            }
        }
        return dp[dp.length - 1];
    }

    private int min(int i, int j) {
        return i < j ? i : j;
    }
}
