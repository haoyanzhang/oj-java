package com.zhy.leetcode.problem.findtheduplicatenumber;

class Solution {

    public int findDuplicate(int[] nums) {

        boolean[] exist = new boolean[nums.length];
        for (int num : nums) {
            if (exist[num]) {
                return num;
            }
            exist[num] = true;
        }
        return -1;
    }
}
