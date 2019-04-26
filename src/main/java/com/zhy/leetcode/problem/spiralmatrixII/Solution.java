package com.zhy.leetcode.problem.spiralmatrixII;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0;
        int j = 0;
        int time = 0;
        int step = 0;
        for (int k = 1; k <= n * n; k++) {
            result[i][j] = k;
            switch (step) {
                case 0:
                    j++;
                    if (j >= n - time) {
                        j--;
                        i++;
                        step++;
                    }
                    break;
                case 1:
                    i++;
                    if (i >= n - time) {
                        i--;
                        j--;
                        step++;
                    }
                    break;
                case 2:
                    j--;
                    if (j < time) {
                        i--;
                        j++;
                        time++;
                        step++;
                    }
                    break;
                case 3:
                    i--;
                    if (i < time) {
                        i++;
                        j++;
                        step = 0;
                    }
            }
        }
        return result;
    }
}