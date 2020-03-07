package com.zhy.leetcode.problem.minimumremovetomakevalidparentheses;

import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {


        Stack<Integer> stack = new Stack<>();
        Set<Integer> removeSet = new HashSet<>();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else if (charArray[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    removeSet.add(i);
                }
            }
        }
        removeSet.addAll(stack);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] != '(' && charArray[i] != ')') || !removeSet.contains(i)) {
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}