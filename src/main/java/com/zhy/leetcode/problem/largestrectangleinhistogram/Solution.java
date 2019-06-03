package com.zhy.leetcode.problem.largestrectangleinhistogram;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == heights.length - 1 || heights[i] > heights[i + 1]) {
                int maxHeight = heights[i];
                for (int j = i; j >= 0; j--) {
                    maxHeight = maxHeight < heights[j] ? maxHeight : heights[j];
                    int rectangle = maxHeight * (i - j + 1);
                    max = max > rectangle ? max : rectangle;
                }
            }
        }
        return max;
    }
}