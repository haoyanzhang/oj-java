package com.zhy.leetcode.contest.weeklycontest176.constructtargetarraywithmultiplesums;

import java.util.Arrays;

class Solution {


    public boolean isPossible(int[] target) {
        int[] start = new int[target.length];
        Arrays.fill(start, 1);
        long sum = 0;
        for (int i : target) {
            sum += i;
        }
        return dfs(target, sum, start, target.length);
    }

    private boolean dfs(int[] target, long targetSum, int[] current, long sum) {

        if (sum == targetSum) {
            return true;
        }

        if (targetSum > Integer.MAX_VALUE) {
            return false;
        }

        for (int i = 0; i < target.length; i++) {
            if (target[i] < sum && target[i] != current[i]) {
                return false;
            }
        }

        boolean result = false;
        for (int i = 0; i < target.length && !result; i++) {
            if (target[i] >= sum) {
                int temp = current[i];
                current[i] = (int)sum;
                result = dfs(target, targetSum, current, sum + sum - temp);
                current[i] = temp;
            }
        }
        return result;
    }
}