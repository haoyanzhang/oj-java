package com.zhy.leetcode.contest.weeklycontest178.howmanynumbersaresmallerthanthecurrentnumber;

import java.util.TreeMap;

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.headMap(nums[i], false)
                    .values()
                    .stream()
                    .mapToInt(a -> a)
                    .sum();
        }
        return result;
    }
}