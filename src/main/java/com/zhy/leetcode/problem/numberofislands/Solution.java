package com.zhy.leetcode.problem.numberofislands;


class Solution {

    public int numIslands(char[][] grid) {

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += recover(grid, i, j)? 1: 0;
            }
        }

        return result;

    }

    private boolean recover(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            recover(grid, i - 1, j);
            recover(grid, i + 1, j);
            recover(grid, i, j - 1);
            recover(grid, i, j + 1);
            return true;
        }
        return false;
    }
}