package com.zhy.leetcode.problem.maximalrectangle;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    heights[i][j] = matrix[i][j] == '1' ? heights[i-1][j] + 1 : 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int result = largestRectangleArea(heights[i]);
            max = max > result ? max : result;
        }
        return max;
    }

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