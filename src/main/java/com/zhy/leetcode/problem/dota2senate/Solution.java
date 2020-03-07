package com.zhy.leetcode.problem.dota2senate;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public String predictPartyVictory(String senate) {

        Queue<Character> queue = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            queue.offer(c);
        }

        int r = 0;
        while (!queue.isEmpty()) {
            if (Math.abs(r) > queue.size()) {
                return r > 0? "Radiant": "Dire";
            }
            Character poll = queue.poll();
            if (r >= 0 && poll.equals('R')) {
                r++;
                queue.offer(poll);
            } else if (r < 0 && poll.equals('R')) {
                r++;
            } else if (r <= 0 && poll.equals('D')) {
                r--;
                queue.offer(poll);
            } else {
                r--;
            }
        }
        return "";
    }
}