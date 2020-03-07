package com.zhy.leetcode.problem.smallestsubsequenceofdistinctcharacters;

import java.util.Stack;

class Solution {

    public String smallestSubsequence(String text) {

        int[] numOfChar = new int[26];

        for (char c : text.toCharArray()) {
            numOfChar[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (stack.contains(c)) {
                numOfChar[c - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && numOfChar[stack.peek() - 'a'] > 1 && stack.peek() > c) {
                numOfChar[stack.peek() - 'a']--;
                stack.pop();
            }
            stack.push(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
