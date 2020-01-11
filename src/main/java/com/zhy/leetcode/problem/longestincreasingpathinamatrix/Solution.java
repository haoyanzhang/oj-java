package com.zhy.leetcode.problem.longestincreasingpathinamatrix;

class Solution {

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }

        int max = 1;

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                max = Math.max(dfs(matrix, i, j, cache), max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        Integer next;
        int max = 1;
        if ((next = get(matrix, i-1, j)) != null && matrix[i][j] > next) {
            max = Math.max(max, dfs(matrix, i-1, j, cache)+1);
        }
        if ((next = get(matrix, i+1, j)) != null && matrix[i][j] > next) {
            max = Math.max(max, dfs(matrix, i+1, j, cache)+1);
        }
        if ((next = get(matrix, i, j-1)) != null && matrix[i][j] > next) {
            max = Math.max(max, dfs(matrix, i, j-1, cache)+1);
        }
        if ((next = get(matrix, i, j+1)) != null && matrix[i][j] > next) {
            max = Math.max(max, dfs(matrix, i, j+1, cache)+1);
        }
        cache[i][j] = max;
        return max;
    }

    private Integer get(int[][] matrix, int i, int j) {
        if (i >= 0 && j >= 0 && i < matrix.length && j < matrix[i].length) {
            return matrix[i][j];
        }
        return null;
    }
}
