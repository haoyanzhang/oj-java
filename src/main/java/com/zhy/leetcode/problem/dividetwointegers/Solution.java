package com.zhy.leetcode.problem.dividetwointegers;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long positiveResult = Math.abs((long)dividend) / Math.abs((long)divisor);
        long result = positive ? positiveResult : -positiveResult;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int)result;
    }
}
