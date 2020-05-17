package com.zhy.leetcode.problem.nextgrEaterelementIII;

import java.util.Map;
import java.util.TreeMap;


class Solution {

    public int nextGreaterElement(int n) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int max = -1;
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (i >= max) {
                max = i;
            } else {
                Integer higherKey = map.higherKey(i);
                n = n * 10 + higherKey;
                if (map.get(higherKey) == 1) {
                    map.remove(higherKey);
                } else {
                    map.put(higherKey, map.get(higherKey) - 1);
                }
                for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                    Integer value = integerIntegerEntry.getValue();
                    while (value > 0) {
                        n = n * 10 + integerIntegerEntry.getKey();
                        value--;
                        if (n % 10 != integerIntegerEntry.getKey()) {
                            return -1;
                        }
                    }
                }
                return n;
            }
        }
        return -1;
    }
}
