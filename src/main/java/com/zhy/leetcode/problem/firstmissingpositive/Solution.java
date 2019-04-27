package com.zhy.leetcode.problem.firstmissingpositive;

class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i =0; i< nums.length; i ++) {
            int val = nums[i];
            while (val != i+1 && val <= nums.length && val > 0 && nums[i] != nums[val - 1]) {
                swap(nums, i, val - 1);
                val = nums[i];
            }
        }
        for (int i =0; i< nums.length; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
