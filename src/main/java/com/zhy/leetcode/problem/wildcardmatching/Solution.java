package com.zhy.leetcode.problem.wildcardmatching;

class Solution {
    public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*+", "*");
        int i = 0;
        int j = 0;
        int start = -1;
        int matchStart = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i ++;
                j ++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                matchStart = i;
                start = j;
                j ++;
            } else if (start != -1) {
                matchStart ++;
                i = matchStart;
                j = start;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j ++;
        }
        return j == p.length();
    }


}
