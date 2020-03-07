package com.zhy.leetcode.contest.weeklycontest176.countnegativenumbersinasortedmatrix;

class Solution {
    public int countNegatives(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int i = grid.length - 1;
        int j = 0;

        int result = 0;

        while (i >= 0 && j < grid[i].length) {
            if (grid[i][j] >= 0) {
                j++;
            } else {
                result += grid[i].length - j;
                i--;
            }
        }

        return result;
    }
}