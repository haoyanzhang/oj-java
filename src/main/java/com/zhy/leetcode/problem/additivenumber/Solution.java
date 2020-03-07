package com.zhy.leetcode.problem.additivenumber;


class Solution {
    public boolean isAdditiveNumber(String num) {

        int i = num.length() / 2;

        for (int i1 = 1; i1 <= i; i1++) {
            for (int i2 = 1; i2 <= i; i2++) {
                if (i1 != 1 && num.charAt(0) == '0') {
                    continue;
                }
                if (i2 != 1 && num.charAt(i1) == '0') {
                    continue;
                }
                if (isAdditiveNumber(Long.valueOf(num.substring(0, i1)), Long.valueOf(num.substring(i1, i1 + i2)), num, i1 + i2)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean isAdditiveNumber(long a, long b, String num, int index) {

        long sum = a + b;
        String s = String.valueOf(sum);
        if (num.length() - index >= s.length() && s.equals(num.substring(index, index + s.length()))) {
            return index + s.length() == num.length() || isAdditiveNumber(b, sum,num, index + s.length());
        }
        return false;
    }
}
