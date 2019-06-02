package com.zhy.leetcode.problem.removeduplicatesfromsortedarrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        int last = -1;
        int time = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last) {
                if (time > 1) {
                    continue;
                } else {
                    time++;
                    nums[pos++] = nums[i];
                }
            } else {
                last = nums[i];
                time = 1;
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
