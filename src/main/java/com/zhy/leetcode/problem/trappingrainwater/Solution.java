package com.zhy.leetcode.problem.trappingrainwater;

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int current = 0;
        int currentHeight = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] < currentHeight) {
                    current += currentHeight - height[i];
                    i ++;
                } else {
                    currentHeight = height[i];
                    i ++;
                }
            } else {
                if (height[j] < currentHeight) {
                    current += currentHeight - height[j];
                    j --;
                } else {
                    currentHeight = height[j];
                    j --;
                }
            }
        }
        return  current;
    }
}
