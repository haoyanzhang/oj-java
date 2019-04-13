package com.zhy.leetcode.problem.longestcommonprefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int pos = 0;
        while (true) {
            Character common = null;
            for (String str : strs) {
                if (str.length() == pos) {
                    return strs[0].substring(0, pos);
                }
                char c = str.charAt(pos);
                if (common == null) {
                    common = c;
                } else if (!common.equals(c)) {
                    return strs[0].substring(0, pos);
                }
            }
            pos++;
        }
    }
}