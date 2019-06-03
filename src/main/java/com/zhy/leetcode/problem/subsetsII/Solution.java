package com.zhy.leetcode.problem.subsetsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            boolean b = map.containsKey(num);
            if (b) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (Integer integer : map.keySet()) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> integerList : result) {
                newResult.add(integerList);
                Integer number = map.get(integer);
                for (int i = 1; i <= number; i++) {
                    List<Integer> list = new ArrayList<>(integerList);
                    for (int j = 0; j < i; j++) {
                        list.add(integer);
                    }
                    newResult.add(list);
                }
            }
            result = newResult;
        }
        return result;
    }
}
