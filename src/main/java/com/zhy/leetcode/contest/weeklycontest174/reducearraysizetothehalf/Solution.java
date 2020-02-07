package com.zhy.leetcode.contest.weeklycontest174.reducearraysizetothehalf;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public int minSetSize(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> sorted = map.values().stream()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }).collect(Collectors.toList());
        int total = arr.length;
        int half = (total + 1) >> 1;
        int cur = 0;
        int result = 0;
        for (int i = 0; i < sorted.size(); i++) {
            result++;
            cur += sorted.get(i);
            if (cur >= half) {
                break;
            }
        }

        return result;
    }
}
