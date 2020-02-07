package com.zhy.leetcode.problem.palindromicsubstrings;

class Solution {

    public int countSubstrings(String s) {

        int result = 0;

        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 0; l < charArray.length; l++) {
            for (int i = 0; l + i < charArray.length; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = charArray[j] == charArray[i];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && charArray[j] == charArray[i];
                }
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}