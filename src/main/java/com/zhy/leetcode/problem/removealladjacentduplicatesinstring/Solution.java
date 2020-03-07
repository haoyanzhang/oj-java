package com.zhy.leetcode.problem.removealladjacentduplicatesinstring;

import java.util.Stack;

class Solution {

    public String removeDuplicates(String S) {

        Stack<Character> characters = new Stack<>();

        for (char c : S.toCharArray()) {
            if (!characters.isEmpty() && characters.peek().equals(c)) {
                characters.pop();
            } else {
                characters.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()) {
            stringBuilder.insert(0, characters.pop());
        }
        return stringBuilder.toString();
    }
}
