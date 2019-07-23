package com.zhy.leetcode.problem.findlirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int val = nums[index];
        int i;
        for (i = index - 1; i >= 0; i --) {
            if (nums[i] != val) {
                break;
            }
        }
        int j;
        for (j = index + 1; j < nums.length; j ++) {
            if (nums[j] != val) {
                break;
            }
        }
        return new int[]{i + 1, j - 1};
    }
}
