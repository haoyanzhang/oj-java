package com.zhy.leetcode.problem.wordladder;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> set = new HashSet<>(wordList);

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(1, beginWord));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.s.equals(endWord)) {
                return poll.step;
            }
            Set<String> toRemove = new HashSet();
            for (String s : set) {
                if (canTran(poll.s, s)) {
                    queue.add(new Node(poll.step + 1, s));
                    toRemove.add(s);
                }
            }
            set.removeAll(toRemove);
        }

        return 0;
    }

    public static class Node {

        public Node(int step, String s) {
            this.step = step;
            this.s = s;
        }

        public int step;

        public String s;
    }

    private boolean canTran(String from, String to) {
        char[] fromChars = from.toCharArray();
        char[] toChars = to.toCharArray();
        int d = 0;
        for (int i = 0; i < fromChars.length && d <= 1; i++) {
            if (fromChars[i] != toChars[i]){
                d++;
            }
        }
        return d == 1;
    }
}

