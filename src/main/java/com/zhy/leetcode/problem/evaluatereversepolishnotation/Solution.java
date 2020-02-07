package com.zhy.leetcode.problem.evaluatereversepolishnotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    private static Set<String> OP_SET;

    static {
        OP_SET = new HashSet<>();
        OP_SET.add("+");
        OP_SET.add("-");
        OP_SET.add("*");
        OP_SET.add("/");

    }


    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if (OP_SET.contains(token)) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public Integer calculate(Integer a, Integer b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        if (op.equals("/")) {
            return a / b;
        }
        throw new UnsupportedOperationException();
    }
}
