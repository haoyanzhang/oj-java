package com.zhy.leetcode.contest.weeklycontest180.luckynumbersinamatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {



    public List<Integer> luckyNumbers (int[][] matrix) {


        List<Integer> result = new ArrayList<>();

        int[] mins = new int[matrix.length];
        int[] columns = new int[matrix.length];

        Arrays.fill(mins, Integer.MAX_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < mins[i]) {
                    mins[i] = matrix[i][j];
                    columns[i] = j;
                }
            }
        }

        int max = 0;
        int index = 0;
        int column = 0;

        for (int i = 0; i < mins.length; i++) {
            if (mins[i] > max) {
                max = mins[i];
                index = i;
                column = columns[index];
            }
        }
        boolean ok = true;
        for (int i = 0; ok && i < matrix.length; i++) {
            if (matrix[i][column] > matrix[index][column]) {
                ok = false;
            }
        }
        if (ok) {
            result.add(max);
        }

        return result;

    }
}