package com.zhy.leetcode.problem.containerwithmostwater;

class Solution {



    public int maxArea(int[] height) {

        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int min = height[i] > height[j] ? height[j] : height[i];
            int result = min * (j - i);
            if (result > max) {
                max = result;
            }
            if (height[i] > height[j]) {
                j --;
            } else {
                i ++;
            }
        }
        return max;
    }
}
