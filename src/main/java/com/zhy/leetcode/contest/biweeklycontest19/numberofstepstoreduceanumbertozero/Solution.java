package com.zhy.leetcode.contest.biweeklycontest19.numberofstepstoreduceanumbertozero;


class Solution {
    public int numberOfSteps (int num) {

        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num >> 1;
            } else {
                num = num - 1;
            }
            step++;
        }

        return step;

    }

}