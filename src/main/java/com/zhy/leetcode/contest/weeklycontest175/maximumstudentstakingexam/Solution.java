package com.zhy.leetcode.contest.weeklycontest175.maximumstudentstakingexam;


class Solution {


    public int maxStudents(char[][] seats) {

        if (seats.length == 0) {
            return 0;
        }

        return dfs(seats, new boolean[seats.length][seats[0].length], 0, 0);
    }

    private int dfs(char[][] seats, boolean[][] hasStudent, int i, int j) {

        if (i == seats.length) {
            return 0;
        }

        if (j >= 2 && i >= 1 && seats[i-1][j-2] == '.'
                && !isSeated(hasStudent, i - 1, j - 2)
                && !isSeated(hasStudent, i - 1, j - 3)
                && !isSeated(hasStudent, i - 1, j - 1)
                && !isSeated(hasStudent, i - 2, j - 1)
                && !isSeated(hasStudent, i - 2, j - 3)
                && !isSeated(hasStudent, i, j - 1)
                && !isSeated(hasStudent, i, j - 3)) {
            return 0;
        }

        if (seats[i][j] == '#') {
            if (j + 1 < seats[i].length) {
                return dfs(seats, hasStudent, i, j + 1);
            } else {
                return dfs(seats, hasStudent, i + 1, 0);
            }
        } else {
            int result = 0;
            if (!isSeated(hasStudent, i - 1, j - 1) && !isSeated(hasStudent, i, j - 1) && !isSeated(hasStudent, i - 1, j + 1)) {
                hasStudent[i][j] = true;
                if (j + 1 < seats[i].length) {
                    result = dfs(seats, hasStudent, i, j + 1) + 1;
                } else {
                    result = dfs(seats, hasStudent, i + 1, 0) + 1;
                }
                hasStudent[i][j] = false;
            }


            if (j + 1 < seats[i].length) {
                result = Math.max(result, dfs(seats, hasStudent, i, j + 1));
            } else {
                result = Math.max(result, dfs(seats, hasStudent, i + 1, 0));
            }

            return result;
        }
    }

    private boolean isSeated(boolean[][] hasStudent, int i, int j) {
        if (i < 0 || i >= hasStudent.length || j < 0 || j >= hasStudent[i].length) {
            return false;
        }
        return hasStudent[i][j];
    }


}
