package com.zhy.leetcode.problem.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> queue = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> nextQueue = new ArrayList<>();
            for (List<Integer> list : queue) {
                if (list.size() + n - i >= k) {
                    ArrayList<Integer> values = new ArrayList<>();
                    values.addAll(list);
                    nextQueue.add(values);
                }
                list.add(i);
                if (list.size() < k) {
                    nextQueue.add(list);
                } else {
                    result.add(list);
                }
            }
            queue = nextQueue;
        }
        return result;
    }

}
