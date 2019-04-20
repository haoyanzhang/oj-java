package com.zhy.leetcode.problem.nextpermutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums){
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = i + 1; j < nums.length + 1; j++) {
                    if (j == nums.length || nums[j] <= nums[i]) {
                        swap(nums, i, j - 1);
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
