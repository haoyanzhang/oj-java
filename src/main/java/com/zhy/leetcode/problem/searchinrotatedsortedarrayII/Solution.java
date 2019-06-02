package com.zhy.leetcode.problem.searchinrotatedsortedarrayII;

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int rotate = findRotate(nums, 0, nums.length);
        if (target >= nums[0]) {
            return binarySearch(nums, 0, rotate, target);
        } else {
            return binarySearch(nums, rotate, nums.length, target);
        }
    }

    private int findRotate(int[] nums, int start, int end) {
        if (nums[start] < nums[end - 1]) {
            return end;
        }
        if (end - start < 4 || nums[start] == nums[end - 1]) {
            for (int i = start; i < end - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return i + 1;
                }
            }
            return end;
        }
        int mid = ((end - start) >> 1) + start;
        if (nums[mid] >= nums[start]) {
            return findRotate(nums, mid, end);
        } else {
            return findRotate(nums, start, mid);
        }
    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
        if (end - start < 4) {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
        int mid = ((end - start) >> 1) + start;
        if (target >= nums[mid]) {
            return binarySearch(nums, mid, end, target);
        } else {
            return binarySearch(nums, start, mid, target);
        }
    }
}
