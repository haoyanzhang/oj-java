package com.zhy.leetcode.problem.longestvalidparentheses;

class Solution {
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
                continue;
            }
            int index = i - 1;
            int lastDp = dp[i - 1];
            if (lastDp > 0) {
                index -= lastDp;
            }
            if (index >= 0 && s.charAt(index) == '(') {
                dp[i] = lastDp + 2 + (index - 1 >= 0 ? dp[index - 1] : 0);
                if (dp[i] > result) {
                    result = dp[i];
                }
            } else {
                dp[i] = 0;
            }
        }
        return result;
    }
}
