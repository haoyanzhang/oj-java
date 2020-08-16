package com.zhy.leetcode.problem.minimumoperationstomakearrayequal;

class Solution {


    public int minOperations(int n) {
        if (n % 2 == 1) {
            n /= 2;
            return (1 + n) * n;
        } else {
            n /= 2;
            return n * n;
        }
    }

}
