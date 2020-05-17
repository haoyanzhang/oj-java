package com.zhy.leetcode.problem.smallestIntegerdivisiblebyk;

class Solution {


    public int smallestRepunitDivByK(int K) {

        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int i = 1;
        int j = 1;
        while (true) {
            i = i % K;
            if (i == 0) {
                return j;
            }
            j++;
            i = i * 10 + 1;
        }
    }
}