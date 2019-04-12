package com.zhy.leetcode.problem.stringtointegeratoi;


class Solution {
    public int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }
        int index = 0;
        int length = str.length();
        while (index < length && str.charAt(index) == ' ') {
            index ++;
        }
        boolean positive = index < length && !(str.charAt(index) == '-');
        if (index < length && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
            index ++;
        }
        while (index < length && str.charAt(index) == '0') {
            index ++;
        }
        int start = index;
        while (index < length && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index ++;
        }
        String substring = str.substring(start, index);
        if (substring.length() > 0) {
            if (substring.length() > 12) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                Long result = Long.valueOf(substring);
                result = positive ? result : -result;
                return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result.intValue();
            }
        }
        return 0;
    }
}
