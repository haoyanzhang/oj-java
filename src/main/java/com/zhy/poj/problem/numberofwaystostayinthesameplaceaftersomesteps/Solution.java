package com.zhy.poj.problem.numberofwaystostayinthesameplaceaftersomesteps;

class Solution {

    public int numWays(int steps, int arrLen) {

        arrLen = Math.min(arrLen, steps + 1);

        long[] dp = new long[arrLen];
        long[] dp2 = new long[arrLen];
        int start = 0;
        dp[0] = 1;

        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                if (start % 2 == 0) {
                    dp2[j] = (get(dp, j - 1) + dp[j] + get(dp, j + 1)) % 1000000007;
                } else {
                    dp[j] = (get(dp2, j - 1) + dp2[j] + get(dp2, j + 1)) % 1000000007;
                }
            }
            start++;
        }

        return start % 2 == 0? (int)dp[0]: (int)dp2[0];
    }

    private long get(long[] dp, int index) {
        if (index < 0 || index >= dp.length) {
            return 0;
        }
        return dp[index];
    }
}
