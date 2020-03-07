package com.zhy.leetcode.contest.weeklycontest177.closestdivisors;

class Solution {
    public int[] closestDivisors(int num) {
        int[] r1 = find(num + 1);
        int[] r2 = find(num + 2);
        return Math.abs(r1[1] - r1[0]) > Math.abs(r2[1] - r2[0])? r2 : r1;
    }

    private int[] find(int input) {
        int i = (int)Math.sqrt(input);
        while (input % i != 0) {
            i--;
        }
        return new int[]{i, input / i};
    }
}
