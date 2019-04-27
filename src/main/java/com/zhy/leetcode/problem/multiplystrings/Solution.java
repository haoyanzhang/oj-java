package com.zhy.leetcode.problem.multiplystrings;

class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i=0; i<num1.length(); i++) {
            for (int j = 0; j<num2.length(); j++) {
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += value;
            }
        }
        char[] chars = new char[result.length];
        int carry = 0;
        for (int i = result.length - 2; i >= 0; i--) {
            int val = result[i] + carry;
            chars[i + 1] = (char) (val % 10 + '0');
            carry = val / 10;
        }
        chars[0] = (char)(carry + '0');
        int firstIndex = 0;
        while (firstIndex < chars.length && chars[firstIndex] == '0') {
            firstIndex ++;
        }
        if (firstIndex == chars.length) {
            return "0";
        }
        return new String(chars, firstIndex, chars.length - firstIndex);
    }
}
