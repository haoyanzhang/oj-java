package com.zhy.leetcode.problem.lastsubstringinlexicographicalorder;


class Solution {
    public String lastSubstring(String s) {
        int resultIndex = 0;
        for (int index = 1; index < s.length(); index++) {
            int k = 0;
            while (index + k < s.length() && s.charAt(resultIndex + k) == s.charAt(index + k)) {
                k++;
            }
            if (index + k < s.length() && s.charAt(resultIndex + k) < s.charAt(index + k)) {
                resultIndex = index;
            } else if (index + k == s.length()) {
                break;
            }
        }
        return s.substring(resultIndex);
    }
}