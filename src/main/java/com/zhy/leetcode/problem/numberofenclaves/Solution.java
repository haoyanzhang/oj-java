package com.zhy.leetcode.problem.numberofenclaves;

class Solution {

    public int numEnclaves(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            if (i == 0 || i == A.length - 1) {
                for (int j = 0; j < A[i].length; j++) {
                    dfs(A, i, j);
                }
            } else {
                dfs(A, i, 0);
                dfs(A, i, A[i].length - 1);
            }
        }

        int result = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    result++;
                }
            }
        }


        return result;
    }

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length) {
            return;
        }
        if (j < 0 || j >= A[i].length) {
            return;
        }
        if (A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }
}
