package com.zhy.leetcode.problem.queuereconstructionbyheight;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int[][] reconstructQueue(int[][] people) {

        int[][] result = new int[people.length][2];
        int pos = 0;

        int[] inDegree = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            inDegree[i] = people[i][1];
        }

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(people[i]);
            }
        }
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            result[pos++] = person;
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] != 0 && people[i][0] <= person[0]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.offer(people[i]);
                    }
                }
            }
        }
        return result;
    }
}