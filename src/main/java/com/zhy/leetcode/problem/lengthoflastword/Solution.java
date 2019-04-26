package com.zhy.leetcode.problem.lengthoflastword;

class Solution {
    public int lengthOfLastWord(String s) {
        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ') {
            start --;
        }
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return start - i;
            }
        }
        return start + 1;
    }
}