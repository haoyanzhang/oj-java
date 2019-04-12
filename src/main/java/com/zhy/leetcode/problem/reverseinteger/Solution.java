package com.zhy.leetcode.problem.reverseinteger;

class Solution {
    public int reverse(int x) {

        boolean positive = x >= 0;
        long result = 0;
        x = x < 0 ? -x : x;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = positive ? result : - result;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int)result;
    }
}
