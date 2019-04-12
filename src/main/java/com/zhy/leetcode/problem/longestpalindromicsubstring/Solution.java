package com.zhy.leetcode.problem.longestpalindromicsubstring;

class Solution {


    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            dp[i][i] = true;
            dp[i][i - 1] = s.charAt(i - 1) == c;
            for (int j = 0; j < i - 1 ;j++) {
                dp[i][j] = dp[i-1][j+1] && c == s.charAt(j);
            }
        }
        int maxi = 0;
        int maxj = 0;
        int max = -1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i ;j++) {
                if (dp[i][j]) {
                    if (i - j > max) {
                        maxi = i;
                        maxj = j;
                        max = i - j;
                    }
                }
            }
        }
        return s.substring(maxj, maxi + 1);
    }
}
