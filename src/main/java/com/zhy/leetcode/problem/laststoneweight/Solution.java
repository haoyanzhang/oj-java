package com.zhy.leetcode.problem.laststoneweight;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() >= 2) {
            Integer biggest = queue.poll();
            Integer secondBiggest = queue.poll();
            if (!biggest.equals(secondBiggest)) {
                queue.offer(biggest - secondBiggest);
            }
        }
        return queue.isEmpty()? 0: queue.poll();
    }
}
