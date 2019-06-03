package com.zhy.leetcode.problem.setmatrixzeroes;

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstLineHasZero = false;
        for (int i : matrix[0]) {
            if (i == 0) {
                isFirstLineHasZero = true;
                break;
            }
        }
        for (int i = 1; i< matrix.length; i++) {
            boolean isLineHasZero = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (matrix[0][j] != 0) {
                        for (int k = 0; k < i; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                    isLineHasZero = true;
                } else if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (isLineHasZero) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (isFirstLineHasZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
