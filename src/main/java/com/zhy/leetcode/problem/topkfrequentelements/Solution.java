package com.zhy.leetcode.problem.topkfrequentelements;


import java.util.*;

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            result.addFirst(poll.getKey());
        }
        return result;

    }
}