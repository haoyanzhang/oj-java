package com.zhy.leetcode.problem.uglynumberIII;

class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long[] lcms = new long[]{lcm(a, b), lcm(a, c), lcm(b, c), lcm(a, lcm(b, c))};

        return (int)search(n, a, b, c, 0, Integer.MAX_VALUE, lcms);
    }

    public long search(int n, int a, int b, int c, long l, long r, long[] lcms) {
        if (l == r) {
            return l;
        }
        long mid = (l + r) >> 1;
        if (mid / a + mid / b + mid / c - mid / lcms[0] - mid / lcms[1] - mid / lcms[2]+  mid / lcms[3] >= n) {
            return search(n, a, b, c, l, mid, lcms);
        } else {
            return search(n, a, b, c, mid + 1, r, lcms);
        }
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        b = b % a;
        return gcd(b, a);
    }
}
