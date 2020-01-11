package com.zhy.leetcode.problem.countofrangesum;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {


    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums.length == 0) {
            return 0;
        }

        long[] sums = new long[nums.length];

        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        TreeMap<Long, Long> map = new TreeMap<Long, Long>();

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sums[i] <= upper && sums[i] >= lower) {
                result++;
            }
            Map<Long, Long> LongLongSortedMap = map.subMap(sums[i] - upper, true, sums[i] - lower, true);
            for (Long value : LongLongSortedMap.values()) {
                result += value;
            }
            map.computeIfAbsent(sums[i], k -> 0L);
            map.put(sums[i], map.get(sums[i]) + 1);
        }

        return result;
    }
}

