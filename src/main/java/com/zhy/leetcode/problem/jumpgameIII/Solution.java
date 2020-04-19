package com.zhy.leetcode.problem.jumpgameIII;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {

        if (arr[start] == 0) {
            return true;
        }

        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int next = poll + arr[poll];
            if (next < arr.length && !visited[next]) {
                visited[next] = true;
                if (arr[next] == 0) {
                    return true;
                } else {
                    queue.offer(next);
                }
            }
            int pre = poll - arr[poll];
            if (pre >= 0 && !visited[pre]) {
                visited[pre] = true;
                if (arr[pre] == 0) {
                    return true;
                } else {
                    queue.offer(pre);
                }
            }
        }
        return false;
    }
}
