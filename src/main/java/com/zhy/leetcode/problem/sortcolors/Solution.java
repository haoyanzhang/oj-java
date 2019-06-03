package com.zhy.leetcode.problem.sortcolors;

class Solution {
    public void sortColors(int[] nums) {
        int oneStart = 0;
        int twoStart = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                swap(nums, i, oneStart);
                if (nums[i] == 1) {
                    swap(nums, i, twoStart);
                }
                oneStart++;
                twoStart++;
            } else if (num == 1) {
                swap(nums, i, twoStart);
                twoStart++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
