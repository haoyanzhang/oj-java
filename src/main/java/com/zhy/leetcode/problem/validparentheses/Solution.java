package com.zhy.leetcode.problem.validparentheses;

class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int pos = 0;
        for (int i =0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[pos] = c;
                pos ++;
            } else {
                if (pos == 0) {
                    return false;
                } else if (c == ')' && stack[pos - 1] == '(') {
                    pos--;
                } else if (c == ']' && stack[pos - 1] == '[') {
                    pos--;
                } else if (c == '}' && stack[pos - 1] == '{') {
                    pos--;
                } else {
                    return false;
                }
            }
        }
        return pos == 0;
    }
}
