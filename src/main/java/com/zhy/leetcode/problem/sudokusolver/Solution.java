package com.zhy.leetcode.problem.sudokusolver;

class Solution {
    public void solveSudoku(char[][] board) {

        boolean[][] raw = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][][] square = new boolean[3][3][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int val = board[i][j] - '1';
                    raw[i][val] = column[j][val] = square[i/3][j/3][val] = true;
                }
            }
        }
        solveSudoku(board, 0, 0, raw, column, square);
    }

    private boolean solveSudoku(char[][] board, int i, int j, boolean[][] raw, boolean[][] column, boolean[][][] square) {
        if (i >= 9) {
            return true;
        }
        if (board[i][j] != '.') {
            j++;
            if (j >= 9) {
                j = 0;
                i++;
            }
            return solveSudoku(board, i, j, raw, column, square);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (raw[i][k-1] || column[j][k-1] || square[i/3][j/3][k-1]) {
                    continue;
                } else {
                    raw[i][k-1] = column[j][k-1] = square[i/3][j/3][k-1] = true;
                    board[i][j] = (char)('0' + k);
                    int nextJ = j + 1;
                    int nextI = i;
                    if (nextJ >= 9) {
                        nextJ = 0;
                        nextI++;
                    }
                    if (solveSudoku(board, nextI, nextJ, raw, column, square)) {
                        return true;
                    } else {
                        raw[i][k-1] = column[j][k-1] = square[i/3][j/3][k-1] = false;
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        }
    }

}
