package com.zhy.leetcode.problem.insertinterval;

import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][];
        int pos = 0;
        boolean add = false;
        for (int[] interval : intervals) {
            if (add || interval[1] < newInterval[0]) {
                result[pos] = interval;
                pos++;
            } else if(interval[0] > newInterval[1]) {
                result[pos] = newInterval;
                pos++;
                result[pos] = interval;
                pos++;
                add = true;
            } else {
                newInterval[0] = newInterval[0] < interval[0] ? newInterval[0] : interval[0];
                newInterval[1] = newInterval[1] < interval[1] ? interval[1] : newInterval[1];
            }
        }
        if (!add) {
            result[pos] = newInterval;
            pos++;
        }
        return Arrays.copyOf(result, pos);
    }
}
