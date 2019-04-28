package com.zhy.leetcode.problem.sqrtx;

class Solution {
    public int mySqrt(int x) {
        return (int)find(x, 0, (long)x + 1);
    }

    private long find(int x, long start, long end) {
        if (end - start <= 4) {
            for (long i = start; i < end; i++) {
                if (x >= i * i && x < (i + 1) * (i + 1)) {
                    return i;
                }
            }
            return -1;
        } else {
            long mid = start + (end - start) / 2;
            if (x >= mid * mid) {
                return find(x, mid, end);
            } else {
                return find(x, start, mid);
            }
        }
    }
}
