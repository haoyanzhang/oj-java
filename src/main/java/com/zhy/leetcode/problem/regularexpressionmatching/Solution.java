package com.zhy.leetcode.problem.regularexpressionmatching;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            boolean any = false;
            if (i < p.length() && p.charAt(i) == '*') {
                any = true;
            }
            if (any) {
                dp[i + 1][0] = dp[i-1][0];
            }
            char pc = p.charAt(i - 1);
            for (int j = 1; j < s.length() + 1; j++) {
                char sc = s.charAt(j - 1);
                if (dp[i-1][j-1]) {
                    if (!any) {
                        dp[i][j] = pc == sc || pc == '.';
                    } else {
                        dp[i+1][j-1] = true;
                        if (pc == '.') {
                            for (int k = j; k < s.length() + 1; k++) {
                                dp[i+1][k] = true;
                            }
                            break;
                        } else {
                            for (int k = j; k < s.length() + 1; k++) {
                                if (s.charAt(k - 1) == pc) {
                                    dp[i+1][k] = true;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (dp[i-1][s.length()] && any) {
                dp[i+1][s.length()] = true;
            }
            if (any) {
                i++;
            }
        }
        return dp[p.length()][s.length()];
    }
}
