package com.zhy.leetcode.problem.dailytemperatures;

import java.util.Stack;

class Solution {

    public int[] dailyTemperatures(int[] T) {
        Stack<Node> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().value <= T[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek().index - i;
            }
            stack.push(new Node(T[i], i));
        }
        return result;
    }
    private static class Node {

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int value;

        public int index;
    }

}