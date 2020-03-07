package com.zhy.leetcode.problem.countvowelspermutation;

import java.util.Arrays;
import java.util.function.IntToLongFunction;

class Solution {
    public int countVowelPermutation(int n) {

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[5];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[5];
            newDp[0] = (int)(((long)dp[1] + dp[2] + dp[4]) % 1000000007);
            newDp[1] = (int)(((long)dp[0] + dp[2]) % 1000000007);
            newDp[2] = (int)(((long)dp[1] + dp[3])  % 1000000007);
            newDp[3] = (int)(((long)dp[2])  % 1000000007);
            newDp[4] = (int)(((long)dp[2] + dp[3])  % 1000000007);
            dp = newDp;
        }

        return (int)(Arrays.stream(dp).mapToLong(i -> (long)i).sum() % 1000000007);
    }
}
