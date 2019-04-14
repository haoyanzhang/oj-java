package com.zhy.leetcode.problem.removeduplicatesfromsortedarray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pos == 0 || nums[i] != nums[pos - 1]) {
                nums[pos] = nums[i];
                pos ++;
            }
        }
        return pos;
    }
}