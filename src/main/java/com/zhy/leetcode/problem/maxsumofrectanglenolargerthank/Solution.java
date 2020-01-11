package com.zhy.leetcode.problem.maxsumofrectanglenolargerthank;

import java.util.TreeSet;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] sum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if (i == 0 && i1 == 0) {
                    sum[i][i1] = matrix[i][i1];
                } else if (i == 0) {
                    sum[i][i1] = matrix[i][i1] + sum[i][i1 - 1];
                } else if (i1 == 0) {
                    sum[i][i1] = matrix[i][i1] + sum[i - 1][i1];
                } else {
                    sum[i][i1] = sum[i - 1][i1] + sum[i][i1-1] - sum[i - 1][i1-1] +matrix[i][i1];
                }
            }
        }

        Integer result = Integer.MIN_VALUE;

        for (int i = 0; i < matrix[0].length; i++) {

            for (int j = -1; j < i; j++) {
                TreeSet<Integer> integers = new TreeSet<>();
                integers.add(0);
                for (int m = 0; m < matrix.length; m++) {
                    int s = sum[m][i] - (j >= 0 ? sum[m][j]: 0);
                    Integer higher = integers.ceiling(s - k);
                    if (higher != null) {
                        result = Math.max(result, s - higher);
                    }
                    integers.add(s);
                }
            }
        }
        return result;
    }
}
