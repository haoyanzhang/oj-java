package com.zhy.leetcode.problem.checkifitisastraightline;

class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length <= 2) {
            return true;
        }

        boolean isKInf = coordinates[1][0] == coordinates[0][0];
        double k = 0d;
        if (!isKInf) {
            k = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        }
        for (int i = 2; i < coordinates.length; i++) {
            if (isKInf) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            } else {
                double k2 = (double) (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]);
                if (Math.abs(k - k2) > 1e-5) {
                    return false;
                }
            }
        }
        return true;
    }
}