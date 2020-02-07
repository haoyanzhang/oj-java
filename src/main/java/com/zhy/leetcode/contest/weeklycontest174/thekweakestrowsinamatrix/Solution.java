package com.zhy.leetcode.contest.weeklycontest174.thekweakestrowsinamatrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {

        if (k == 0) {
            return new int[0];
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int compareNum = o2.num - o1.num;
                return compareNum == 0? o2.index - o1.index: compareNum;
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int num = numOfOne(mat[i], 0, mat[i].length);
            if (queue.size() < k) {
                queue.offer(new Node(i, num));
            } else if (!queue.isEmpty() && queue.peek().num > num) {
                queue.poll();
                queue.offer(new Node(i, num));
            }
        }

        int[] result = new int[k];
        int pos = k-1;
        while (!queue.isEmpty()) {
            result[pos--] = queue.poll().index;
        }

        return result;
    }

    private int numOfOne(int[] row, int from, int to) {
        if (from + 1 >= to) {
            if (from + 1 == to) {
                return row[from];
            }
            return 0;
        }
        int mid = (from + to) >> 1;
        if (row[mid] == 1) {
            return mid - from + numOfOne(row, mid, to);
        } else {
            return numOfOne(row, from, mid);
        }
    }

    private static class Node {

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        public int index;

        public int num;
    }
}