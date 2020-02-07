package com.zhy.leetcode.problem.countingbits;

class Solution {


    public int[] countBits(int num) {

        int[] result = new int[num + 1];
        result[0] = 0;
        int pos = 1;
        int cur = 0;
        int curLast = 0;
        while (pos < result.length) {
            result[pos] = 1 + result[cur];
            if (cur == curLast) {
                cur = 0;
                curLast = pos;
            } else {
                cur++;
            }
            pos++;
        }
        return result;
    }
}