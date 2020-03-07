package com.zhy.leetcode.problem.shortestpathvisitingallnodes;


import java.util.*;

class Solution {


    public int shortestPathLength(int[][] graph) {

        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        HashSet<Integer> remain = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            remain.add(i);
        }
        for (int i = 0; i < graph.length; i++) {
            HashSet<Integer> nextRemain = new HashSet<>(remain);
            nextRemain.remove(i);
            queue.offer(new Node(0, i, nextRemain));
        }
        while (!queue.isEmpty()) {
            Node poll = queue.poll();


            int[] nexts = graph[poll.curPosition];
            for (int next : nexts) {
                HashSet<Integer> nextRemain = new HashSet<>(poll.remain);
                nextRemain.remove(next);
                if (nextRemain.isEmpty()) {
                    return poll.step + 1;
                }
                Node nextNode = new Node(poll.step + 1, next, nextRemain);
                if (!set.contains(nextNode)) {
                    set.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }
        return 0;
    }

    private static class Node {

        public Node(int step, int curPosition, Set<Integer> remain) {
            this.step = step;
            this.curPosition = curPosition;
            this.remain = remain;
        }

        public int step;

        public int curPosition;

        public Set<Integer> remain;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return curPosition == node.curPosition &&
                    Objects.equals(remain, node.remain);
        }

        @Override
        public int hashCode() {
            return Objects.hash(curPosition, remain);
        }
    }
}