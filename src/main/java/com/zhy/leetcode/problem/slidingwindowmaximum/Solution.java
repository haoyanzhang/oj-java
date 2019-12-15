package com.zhy.leetcode.problem.slidingwindowmaximum;

import java.util.*;

/**
 * @author zhanghaoyan
 */
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }

        return result;
    }
}