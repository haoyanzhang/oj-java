package com.zhy.leetcode.problem.subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> nextQueue = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(num);
                nextQueue.add(list);
                nextQueue.add(copy);
            }
            result = nextQueue;
        }
        return result;
    }
}
