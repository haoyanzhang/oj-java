package com.zhy.leetcode.problem.findminimuminrotatedsortedarrayII;

class Solution {


    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int from, int to) {
        if (to - from < 5) {
            return findDirectly(nums, from, to);
        }
        int mid = ((to - from) >> 1) + from;
        if (nums[mid] < nums[from]) {
            return findMin(nums, from, mid);
        } else if (nums[mid] > nums[to]) {
            return findMin(nums, mid, to);
        } else if (nums[mid] > nums[from] && nums[mid] < nums[to] || nums[mid] == nums[from] && nums[mid] < nums[to] || nums[mid] > nums[from] && nums[mid] == nums[to] ) {
            return nums[from];
        }
        return findDirectly(nums, from, to);
    }

    private int findDirectly(int[] nums, int from, int to) {
        for (int i = from + 1; i <= to; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[from];
    }
}
