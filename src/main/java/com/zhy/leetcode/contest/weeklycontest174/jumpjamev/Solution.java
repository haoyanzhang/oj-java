package com.zhy.leetcode.contest.weeklycontest174.jumpjamev;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {

    public int maxJumps(int[] arr, int d) {

        int result = 0;
        int[] resultArr = new int[arr.length];
        Arrays.fill(resultArr, -1);
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, jump(i, arr, d, resultArr));
        }
        return result + 1;
    }

    private int jump(int i, int[] arr, int d, int[] result) {
        if (result[i] != -1) {
            return result[i];
        }
        int res = 0;
        for (int j = 1; j <= d && i + j < arr.length; j++) {
            if (arr[i + j] >= arr[i]) {
                break;
            }
            res = Math.max(res, jump(i + j, arr, d, result) + 1);
        }
        for (int j = 1; j <= d && i - j >= 0; j++) {
            if (arr[i - j] >= arr[i]) {
                break;
            }
            res = Math.max(res, jump(i - j, arr, d, result) + 1);
        }
        return result[i] = res;
    }
}