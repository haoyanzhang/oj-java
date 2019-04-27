package com.zhy.leetcode.problem.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] result = new int[intervals.length][];
        int pos = 0;
        int[] last = null;
        for (int[] interval : intervals) {
            if (last == null) {
                last = interval;
            } else if (interval[0] <= last[1]) {
                last[1] = last[1] > interval[1] ? last[1] : interval[1];
            } else {
                result[pos] = last;
                last = interval;
                pos ++;
            }
        }
        result[pos] = last;
        return Arrays.copyOf(result, pos + 1);
    }
}