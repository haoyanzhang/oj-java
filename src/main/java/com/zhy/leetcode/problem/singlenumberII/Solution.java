package com.zhy.leetcode.problem.singlenumberII;

class Solution {



    public int singleNumber(int[] nums) {
        int i = 0;int j = 0;// 00 01 10
        for (int num : nums) {
            j ^= num & ~i;
            i ^= num & ~j;
        }
        return j;
    }
}
