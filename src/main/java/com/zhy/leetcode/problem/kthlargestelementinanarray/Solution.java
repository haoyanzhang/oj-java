package com.zhy.leetcode.problem.kthlargestelementinanarray;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int findKthLargest(int[] nums, int k) {


        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }

        return queue.peek();
    }
}
