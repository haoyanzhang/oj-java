package com.zhy.leetcode.problem.nqueens;

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean[] row;
    boolean[] column;
    boolean[] rightTopToLeftBottom;
    boolean[] leftTopToRightBottom;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n];
        column = new boolean[n];
        rightTopToLeftBottom = new boolean[2 * n - 1];
        leftTopToRightBottom = new boolean[2 * n - 1];
        result = new ArrayList<>();
        boolean[][] init = new boolean[n][n];
        solveNQueens(init, 0, 0, n, 0);
        return result;
    }

    private void solveNQueens(boolean[][] cur, int i, int j, int n, int num) {
        if (num == n) {
            List<String> list = new ArrayList<>();
            for (boolean[] booleans : cur) {
                StringBuilder stringBuilder = new StringBuilder();
                for (boolean aBoolean : booleans) {
                    stringBuilder.append(aBoolean ? 'Q' : '.');
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return;
        }
        if (i == n) {
            return;
        }
        int nextJ = j + 1;
        int nextI = i;
        if (nextJ == n) {
            nextJ = 0;
            nextI ++;
        }
        solveNQueens(cur, nextI, nextJ, n, num);
        if (!(row[i] || column[j] || rightTopToLeftBottom[i - j + n - 1] || leftTopToRightBottom[i + j])) {
            row[i] = column[j] = rightTopToLeftBottom[i - j + n - 1] = leftTopToRightBottom[i + j] = true;
            cur[i][j] = true;
            solveNQueens(cur, nextI, nextJ, n, num + 1);
            cur[i][j] = false;
            row[i] = column[j] = rightTopToLeftBottom[i - j + n - 1] = leftTopToRightBottom[i + j] = false;
        }
    }
}
