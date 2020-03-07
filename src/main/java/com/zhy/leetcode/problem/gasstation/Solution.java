package com.zhy.leetcode.problem.gasstation;


import java.util.LinkedList;
import java.util.ListIterator;

class Solution {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        
        int[] remain = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remain[i] = gas[i] - cost[i];
        }

        LinkedList<Node> nodes = new LinkedList<>();

        nodes.add(new Node(remain[0], 0));

        for (int i = 1; i < remain.length; i++) {
            int lastRemain = nodes.peekLast().remain;
            if (remain[i] <= 0 || lastRemain >= 0) {
                nodes.peekLast().remain = lastRemain + remain[i];
            } else {
                nodes.add(new Node(remain[i], i));
            }
        }

        while (nodes.size() > 1) {
            Node node = nodes.pollFirst();
            int lastRemain = nodes.peekLast().remain;
            if (node.remain <= 0 || lastRemain >= 0) {
                nodes.peekLast().remain = lastRemain + node.remain;
            } else {
                nodes.add(node);
            }
        }
        Node node = nodes.pollFirst();
        return node.remain >= 0? node.index: -1;


    }
    
    private static class Node {

        public Node(int remain, int index) {
            this.remain = remain;
            this.index = index;
        }

        public int remain;
        
        public int index;
    }
}
