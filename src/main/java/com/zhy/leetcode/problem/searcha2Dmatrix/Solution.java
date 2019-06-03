package com.zhy.leetcode.problem.searcha2Dmatrix;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int line = findLine(matrix, target, 0, matrix.length);
        for (int i = 0; i < line; i++) {
            boolean b = Arrays.binarySearch(matrix[i], target) >= 0;
            if (b) {
                return true;
            }
        }
        return false;
    }

    private int findLine(int[][] matrix, int target, int from, int to) {
        if (to - from <= 4) {
            for (int i = from; i < to; i++) {
                if (matrix[i][0] > target) {
                    return i;
                }
            }
            return to;
        }
        int mid = from + (to - from) / 2;
        if (matrix[mid][0] > target) {
            return findLine(matrix, target, from, mid);
        } else {
            return findLine(matrix, target, mid, to);
        }
    }
}
