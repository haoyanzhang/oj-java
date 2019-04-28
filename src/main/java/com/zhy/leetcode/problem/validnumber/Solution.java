package com.zhy.leetcode.problem.validnumber;

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int index = s.indexOf('e');
        if (index >= 0) {
            return isNumber(s.substring(0, index), true) && isNumber(s.substring(index + 1), false);
        } else {
            return isNumber(s, true);
        }
    }

    private boolean isNumber(String s, boolean withPoint) {
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (s.equals( ".")) {
            return false;
        }
        int i = s.indexOf('.');
        if (i >= 0) {
            return withPoint && isDigit(s.substring(0, i), true) && isDigit(s.substring(i + 1), true);
        } else {
            return isDigit(s, false);
        }
    }

    private boolean isDigit(String s, boolean empty) {
        if (s.length() == 0) {
            return empty;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            return false;
        }
        return true;
    }
}
