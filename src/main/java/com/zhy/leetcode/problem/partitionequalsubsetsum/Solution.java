package com.zhy.leetcode.problem.partitionequalsubsetsum;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int mid = sum >> 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return dfs(map.entrySet().stream().collect(Collectors.toList()), 0, mid);
    }

    public boolean dfs(List<Map.Entry<Integer, Integer>> list, int index, int target) {
        if (target < 0) {
            return false;
        } if (index == list.size()) {
            return target == 0;
        }
        Map.Entry<Integer, Integer> entry = list.get(index);
        boolean result = false;
        for (Integer value = entry.getValue(); value >= 0; value--) {
            result = result || dfs(list, index + 1, target - entry.getKey() * value);
        }
        return result;
    }
}