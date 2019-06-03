package com.zhy.leetcode.problem.decodeways;

class Solution {
    public int numDecodings(String s) {
        int first = 1;
        int second = 1;
        char[] chars = s.toCharArray();
        char lastChar = '9';
        for (char aChar : chars) {
            if ((lastChar >= '3' || lastChar == '0') && aChar == '0') {
                return 0;
            }
            int next = aChar == '0' ? first : lastChar == '1' || lastChar == '2' && aChar <='6' ? first + second : second;
            first = second;
            second = next;
            lastChar = aChar;
        }
        return second;
    }
}
