package com.zhy.leetcode.problem.integertoroman;

class Solution {

    private String[] symbols = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = values.length - 1;
        while (i >= 0) {
            if (num >= values[i]) {
                stringBuilder.append(symbols[i]);
                num -= values[i];
                continue;
            } else {
                i--;
            }
        }
        return stringBuilder.toString();
    }

}