package com.zhy.leetcode.problem.searcha2DmatrixII;

class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
