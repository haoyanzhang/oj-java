package com.zhy.leetcode.problem.wordsearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, String word, int index, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (used[x][y]) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        used[x][y] = true;
        boolean result = exist(board, x - 1, y, word, index + 1, used)
                || exist(board, x + 1, y, word, index + 1, used)
                || exist(board, x, y - 1, word, index + 1, used)
                || exist(board, x, y + 1, word, index + 1, used);
        used[x][y] = false;
        return result;
    }
}
