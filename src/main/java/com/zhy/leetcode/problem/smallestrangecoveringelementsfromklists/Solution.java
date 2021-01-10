package com.zhy.leetcode.problem.smallestrangecoveringelementsfromklists;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[]{-1000000, 1000000};

        PriorityQueue<Ele> queue = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (List<Integer> num : nums) {
            if (num.size() > 0) {
                Ele ele = new Ele(num, 0);
                queue.offer(ele);
                max = Math.max(max, ele.value());
            }
        }

        while (true) {
            int[] newResult = new int[]{queue.peek().value(), max};
            if (newResult[1] - newResult[0] < result[1] - result[0]) {
                result = newResult;
            }
            Ele ele = queue.poll();
            if (ele.toNext()) {
                queue.offer(ele);
                max = Math.max(max, ele.value());
            } else {
                break;
            }
        }
        return result;
    }


    public static class Ele implements Comparable<Ele> {

        public List<Integer> data;

        public int index;

        public Ele(List<Integer> data, int index) {
            this.data = data;
            this.index = index;
        }

        public int value() {
            return data.get(index);
        }

        public boolean toNext() {
            index++;
            return index < data.size();
        }

        @Override
        public int compareTo(Ele ele) {
            return Float.compare(value() + 0.1f, ele.value());
        }
    }
}
