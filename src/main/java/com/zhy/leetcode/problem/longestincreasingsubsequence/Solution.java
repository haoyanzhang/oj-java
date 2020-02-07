package com.zhy.leetcode.problem.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {


    public int lengthOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            if (len == 0) {
                lis[len++] = num;
            } else {
                int index = findFirstLargerThanOrEquals(lis, 0, len, num);
                if (index == len) {
                    lis[len++] = num;
                } else {
                    lis[index] = num;
                }
            }
        }

        return len;
    }

    private int findFirstLargerThanOrEquals(int[] nums, int from, int to, int target) {
        if (from >= to - 1) {
            return nums[from] >= target? from: from + 1;
        }
        int mid = (from + to) >> 1;
        if (target >= nums[mid]) {
            return findFirstLargerThanOrEquals(nums, mid, to, target);
        } else {
            return findFirstLargerThanOrEquals(nums, from, mid, target);
        }
    }
}