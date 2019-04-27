package com.zhy.leetcode.problem.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int i = 0;
        int j = 0;
        int time = 0;
        int step = 0;
        int num = matrix.length * matrix[0].length;
        while (result.size() < num) {
            switch (step) {
                case 0:
                    while (j < matrix[0].length - time) {
                        result.add(matrix[i][j]);
                        j++;
                    }
                    j--;
                    i++;
                    step++;
                    break;
                case 1:
                    while (i < matrix.length - time) {
                        result.add(matrix[i][j]);
                        i++;
                    }
                    i--;
                    j--;
                    step++;
                    break;
                case 2:
                    while (j >= time) {
                        result.add(matrix[i][j]);
                        j--;
                    }
                    j++;
                    i--;
                    step++;
                    time++;
                    break;
                case 3:
                    while (i >= time) {
                        result.add(matrix[i][j]);
                        i--;
                    }
                    j++;
                    i++;
                    step = 0;
                    break;
            }
        }
        return result;
    }
}
