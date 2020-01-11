package com.zhy.leetcode.problem.arithmeticslicesIIsubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghaoyan
 */
class Solution {


    public int numberOfArithmeticSlices(int[] A) {

        if(A.length == 0) {
            return 0;
        }

        Map<Long, Integer>[] dp = new Map[A.length];

        dp[0] = new HashMap<>();

        int res = 0;

        for (int i = 1; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long sub = (long)A[i] - A[j];
                Integer numJ = dp[j].get(sub);
                Integer numI = dp[i].get(sub);

                int num = 1 + (numI != null ? numI : 0) + (numJ != null ? numJ : 0);
                dp[i].put(sub, num);
                if (numJ != null && numJ >= 1) {
                    res += numJ;
                }
            }
        }
        return res;
    }


}