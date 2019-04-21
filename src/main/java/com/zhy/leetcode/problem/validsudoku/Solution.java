package com.zhy.leetcode.problem.validsudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] raw = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][][] square = new boolean[3][3][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int val = board[i][j] - '1';
                    if (raw[i][val] || column[j][val] || square[i/3][j/3][val]) {
                        return false;
                    }
                    raw[i][val] = column[j][val] = square[i/3][j/3][val] = true;
                }
            }
        }
        return true;
    }
}
