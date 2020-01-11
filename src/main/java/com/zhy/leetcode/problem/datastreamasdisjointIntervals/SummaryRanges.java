package com.zhy.leetcode.problem.datastreamasdisjointIntervals;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class SummaryRanges {

    private TreeMap<Integer, Integer> map= new TreeMap<>();

    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Map.Entry<Integer, Integer> integerEntry = map.lowerEntry(val);
        if (integerEntry != null && integerEntry.getValue() >= val) {
            return;
        } else if (integerEntry != null && integerEntry.getValue().equals(val - 1)) {
            Integer integer = map.get(val + 1);
            if (integer == null) {
                map.put(integerEntry.getKey(), val);
            } else {
                map.put(integerEntry.getKey(), integer);
                map.remove(val + 1);
            }
        } else {
            Integer integer = map.get(val + 1);
            if (integer == null) {
                map.put(val, val);
            } else {
                map.put(val, integer);
                map.remove(val + 1);
            }
        }
    }

    public int[][] getIntervals() {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int[][] result = new int[entries.size()][2];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            result[pos][0] = entry.getKey();
            result[pos][1] = entry.getValue();
            pos ++;
        }
        return result;
    }
}