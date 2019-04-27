package com.zhy.leetcode.problem.powxn;

class Solution {
    public double myPow(double x, int n) {
        long m = (long)n;
        return m > 0 ? quickPow(x, m) : m < 0 ? 1 / quickPow(x, -m) : 1;
    }

    private double quickPow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double p = quickPow(x, n / 2);
        return p * p * (n % 2 == 1 ? x : 1);
    }
}
