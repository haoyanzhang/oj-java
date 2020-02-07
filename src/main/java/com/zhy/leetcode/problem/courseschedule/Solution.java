package com.zhy.leetcode.problem.courseschedule;

import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] next = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < next.length; i++) {
            next[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            next[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        int num = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < next.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                num++;
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : next[poll]) {
                indegree[integer] -= 1;
                if (indegree[integer] == 0) {
                    queue.offer(integer);
                    num ++;
                }
            }
        }

        return num == numCourses;
    }
}
