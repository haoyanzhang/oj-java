package com.zhy.leetcode.problem.targetsum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public int findTargetSumWays(int[] nums, int S) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return dfs(map.entrySet().stream().collect(Collectors.toList()), 0, S);
    }
    public int dfs(List<Map.Entry<Integer, Integer>> entries, int index, int target) {
        if (index == entries.size()) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        Map.Entry<Integer, Integer> entry = entries.get(index);
        int result = 0;
        Integer time = entry.getValue();
        Integer num = entry.getKey();
        for (int i = 0; i <= time; i++) {
            result += dfs(entries, index + 1, target + 2 * i * num - time * num) * c(time, i);
        }
        return result;
    }

    public int c(int i, int j) {
        long a = 1;
        long b = 1;
        for (int k = 0; k < j; k++) {
            a *= i - k;
            b *= k + 1;
        }
        return (int)(a / b);
    }

}