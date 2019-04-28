package com.zhy.leetcode.problem.addbinary;

import java.util.Arrays;

class Solution {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int length = aChars.length > bChars.length ? aChars.length : bChars.length;
        char[] result = new char[length + 1];
        boolean carry  = false;
        for (int i = 0; i < length; i++) {
            int res = getValue(aChars, i) + getValue(bChars, i) + (carry ? 1 : 0);
            if (res >= 2) {
                carry = true;
                res -= 2;
            } else {
                carry = false;
            }
            result[result.length - 1 - i] = (char)(res + '0');
        }
        if (carry) {
            result[0] = '1';
        } else {
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        return new String(result);
    }

    private int getValue(char[] chars, int index) {
        int i = chars.length - 1 - index;
        if (i >= 0) {
            return chars[i] - '0';
        }
        return 0;
    }
}
