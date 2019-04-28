package com.zhy.leetcode.problem.plusone;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 && carry; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                carry = false;
            }
        }
        if (carry) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            digits = res;
        }
        return digits;
    }
}
