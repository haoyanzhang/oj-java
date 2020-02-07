package com.zhy.leetcode.problem.decodestring;

import java.util.Stack;

class Solution {

    public String decodeString(String s) {

        if (s.equals("")) {
            return "";
        }

        Stack<Object> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <='9') {
                int num = chars[i] - '0';
                while (chars[i+1] != '[') {
                    i++;
                    num *= 10;
                    num += chars[i] - '0';
                }
                stack.push(num);
                i++;
            } else if((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                int start = i;
                while (i + 1 < chars.length && ((chars[i+1] >= 'a' && chars[i+1] <= 'z') || (chars[i+1] >= 'A' && chars[i+1] <= 'Z'))) {
                    i++;
                }
                String newString = s.substring(start, i + 1);
                if (!stack.isEmpty() && stack.peek() instanceof String) {
                    Object top = stack.pop();
                    stack.push(top + newString);
                } else {
                    stack.push(newString);
                }
            } else if (chars[i] == ']') {
                Object pop = stack.pop();
                if (pop instanceof Integer) {
                    continue;
                }
                String repeatString = (String)pop;
                Integer time = (Integer) stack.pop();
                StringBuilder stringBuilder = new StringBuilder();
                for (int repeat = 0; repeat < time; repeat++) {
                    stringBuilder.append(repeatString);
                }
                String newString = stringBuilder.toString();
                if (!stack.isEmpty() && stack.peek() instanceof String) {
                    Object top = stack.pop();
                    stack.push(top + newString);
                } else {
                    stack.push(newString);
                }
            }
        }

        return (String)stack.pop();
    }
}