package com.zhy.leetcode.problem.removeinvalidparentheses;


import java.util.*;

/**
 * @author zhanghaoyan
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {

        char[] chars = s.toCharArray();

        Stack<Item> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add(new Item(Parentheses.LEFT, i));
            } else if (chars[i] == ')') {
                if (!stack.isEmpty() && stack.peek().getParentheses().equals(Parentheses.LEFT)) {
                    stack.pop();
                } else {
                    stack.add(new Item(Parentheses.RIGHT, i));
                }
            }
        }
        List<Item> leftList = new ArrayList<>();
        List<Item> rightList = new ArrayList<>();
        while (!stack.isEmpty()) {
            Item item = stack.pop();
            if (item.getParentheses().equals(Parentheses.LEFT)) {
                leftList.add(item);
            } else {
                rightList.add(item);
            }
        }

        List<String> result = new ArrayList<>();
        remove(chars, leftList, 0,  chars.length - 1, rightList, 0, 0, result);
        return result;

    }

    private void remove(char[] chars, List<Item> leftList, int leftIndex, int leftRemoveIndex, List<Item> rightList, int rightIndex, int rightRemoveIndex, List<String> result) {
        if (leftIndex < leftList.size()) {
            Item item = leftList.get(leftIndex);
            for (int i = leftRemoveIndex; i >= item.getIndex(); i--) {
                if (chars[i] == '(') {
                    chars[i] = (char)0;
                    remove(chars, leftList, leftIndex + 1, i - 1, rightList, rightIndex, rightRemoveIndex, result);
                    chars[i] = '(';
                    while (i - 1 >= item.getIndex() && chars[i - 1] == '(') {
                        i--;
                    }
                }
            }
        } else if (rightIndex < rightList.size()) {
            Item item = rightList.get(rightList.size() - rightIndex - 1);
            for (int i = rightRemoveIndex; i <= item.getIndex(); i++) {
                if (chars[i] == ')') {
                    chars[i] = (char)0;
                    remove(chars, leftList, leftIndex, leftRemoveIndex, rightList, rightIndex + 1, i + 1, result);
                    chars[i] = ')';
                    while (i + 1 <= item.getIndex() && chars[i + 1] == ')') {
                        i++;
                    }
                }
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                if (aChar != (char)0) {
                    stringBuilder.append(aChar);
                }
            }
            result.add(stringBuilder.toString());
        }
    }

    private static class Item {

        public Item(Parentheses parentheses, Integer index) {
            this.parentheses = parentheses;
            this.index = index;
        }

        private Parentheses parentheses;

        private Integer index;

        public Parentheses getParentheses() {
            return parentheses;
        }

        public void setParentheses(Parentheses parentheses) {
            this.parentheses = parentheses;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }

    private enum Parentheses {

        LEFT,

        RIGHT
    }
}
