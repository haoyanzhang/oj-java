package com.zhy.leetcode.problem.distinctsubsequences;

/**
 * @author zhanghaoyan
 */
public class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < tCharArray.length; i++) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;
        for (int i = 0; i < sCharArray.length; i++) {
            for (int j = 0; j < tCharArray.length; j++) {
                if (sCharArray[i] == tCharArray[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[sCharArray.length][tCharArray.length];
    }


}
