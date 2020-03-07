package com.zhy.leetcode.problem.base7;

class Solution {

    public String convertToBase7(int num) {

        return num == 0? "0": num > 0? convertToBase7_2(num).toString(): "-" + convertToBase7_2(-num).toString();
    }

    private StringBuilder convertToBase7_2(int num) {
        if (num == 0) {
            return new StringBuilder();
        }
        return convertToBase7_2(num / 7).append(num % 7);
    }
}
