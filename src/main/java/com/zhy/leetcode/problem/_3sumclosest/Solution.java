package com.zhy.leetcode.problem._3sumclosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestOffset = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (j >= k) {
                continue;
            }
            int t = target - nums[i];
            while (j < k) {
                int offset = nums[j] + nums[k] - t;
                if (Math.abs(offset) < Math.abs(closestOffset)) {
                    closestOffset = offset;
                }
                if(offset > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return target + closestOffset;
    }
}
