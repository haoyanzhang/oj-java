package com.zhy.leetcode.contest.weeklycontest176.maximumnumberofeventsthatcanbeattended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {


    public int maxEvents(int[][] events) {

        if (events.length == 0) {
            return 0;
        }

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();

        int day = events[0][0];
        int pos = 0;
        int result = 0;
        while (pos < events.length || !queue.isEmpty()) {
            while (pos < events.length && events[pos][0] == day) {
                queue.offer(events[pos][1]);
                pos++;
            }
            while (!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.poll();
                result++;
            }
            day++;
        }
        return result;

    }
}