package com.zhy.leetcode.problem.basiccalculator;

import java.util.Stack;

/**
 * @author zhanghaoyan
 */
class Solution {



    public int calculate(String s) {


        char[] chars = s.toCharArray();

        Stack<Integer> numberStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();

        int num = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == ' ') {
                continue;
            } else if (c == '+' || c == '-') {
                while (!opStack.empty() && !opStack.peek().equals('(')) {
                    Character op = opStack.pop();
                    Integer lastNum = numberStack.pop();
                    num = cal(op, lastNum, num);
                }
                numberStack.push(num);
                num = 0;
                opStack.push(c);
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.peek().equals('(')) {
                    Character op = opStack.pop();
                    Integer lastNum = numberStack.pop();
                    num = cal(op, lastNum, num);
                }
                opStack.pop();
                while (!opStack.empty() && !opStack.peek().equals('(')) {
                    Character op = opStack.pop();
                    Integer lastNum = numberStack.pop();
                    num = cal(op, lastNum, num);
                }
            }
        }
        if (!opStack.empty() ) {
            Character op = opStack.pop();
            Integer lastNum = numberStack.pop();
            num = cal(op, lastNum, num);
        }
        return num;
    }

    private int cal(Character op, int i, int j) {
        if (op.equals('+')) {
            return i + j;
        } else {
            return i - j;
        }
    }
}
