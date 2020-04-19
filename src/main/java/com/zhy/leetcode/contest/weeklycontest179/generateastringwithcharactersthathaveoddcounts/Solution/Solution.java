package com.zhy.leetcode.contest.weeklycontest179.generateastringwithcharactersthathaveoddcounts.Solution;

class Solution {

    public int numTimesAllBlue(int[] light) {

        int max = Integer.MIN_VALUE;

        int res = 0;
        for (int i = 0; i < light.length; i++) {

            max = Math.max(max, light[i]);

            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }
}