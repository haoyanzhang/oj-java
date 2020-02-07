package com.zhy.leetcode.problem.findpeakelement;

class Solution {


    public int findPeakElement(int[] nums) {

        if (nums.length <= 1) {
            return nums.length - 1;
        }

        int index = 0;

        while (index < nums.length - 1) {
            if (nums[index] > nums[index + 1]) {
                return index;
            }
            index++;
        }

        return index;
    }
}