package com.zhy.leetcode.problem.totalhammingdistance;

class Solution {


    public int totalHammingDistance(int[] nums) {

        int[] bit = new int[32];

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int num = nums[i];
            while (num > 0) {
                if ((num & 1) > 0) {
                    result += i - bit[j];
                    bit[j]++;
                } else {
                    result += bit[j];
                }
                num >>= 1;
                j++;
            }
            for (int k = j; k < bit.length; k++) {
                result += bit[k];
            }
        }

        return result;
    }
}
