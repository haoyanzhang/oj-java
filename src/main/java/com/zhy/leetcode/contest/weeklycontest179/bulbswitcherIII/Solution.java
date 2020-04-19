package com.zhy.leetcode.contest.weeklycontest179.bulbswitcherIII;

import java.util.Arrays;

class Solution {


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {


        int[] cache = new int[manager.length];
        Arrays.fill(cache, -1);

        int res = 0;
        for (int i = 0; i < manager.length; i++) {
            res = Math.max(res, cal(i, manager, informTime, cache));
        }

        return res;
    }

    private int cal(int curIndex,int[] manager, int[] informTime, int[] cache) {
        if (manager[curIndex] == -1) {
            return 0;
        }
        if (cache[curIndex] != -1) {
            return cache[curIndex];
        }
        return cache[curIndex] = cal(manager[curIndex], manager, informTime, cache) + informTime[manager[curIndex]];

    }
}