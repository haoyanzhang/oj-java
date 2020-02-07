package com.zhy.leetcode.problem.coursescheduleII;


import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        List<Integer>[] next = new List[numCourses];
        for (int i = 0; i < next.length; i++) {
            next[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            next[prerequisite[1]].add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int pos = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[pos++] = poll;
            for (Integer i : next[poll]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return pos == result.length? result: new int[0];

    }
}