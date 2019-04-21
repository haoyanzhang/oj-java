package com.zhy.leetcode.problem.searchinsertposition;

import java.util.Arrays;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i >= 0 ? i : -i - 1;
    }
}
