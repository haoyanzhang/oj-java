package com.zhy.leetcode.problem.jumpgame;

class Solution {
    public boolean canJump(int[] nums) {
        Integer need = null;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (need != null && nums[i] < need) {
                need ++;
            } else if (need != null && nums[i] >= need) {
                need = null;
            } else if (need == null && nums[i] == 0) {
                need = 2;
            }
        }
        return need == null;
    }
}
