package com.zhy.leetcode.contest.weeklycontest179.timeneededtoinformallemployees;

class Solution {
    public String generateTheString(int n) {

        if (n == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (n % 2 == 1) {
            while (n > 0) {
                stringBuilder.append('a');
                n--;
            }
        } else {
            while (n > 1) {
                stringBuilder.append('a');
                n--;
            }
            stringBuilder.append('b');
        }

        return stringBuilder.toString();
    }
}
