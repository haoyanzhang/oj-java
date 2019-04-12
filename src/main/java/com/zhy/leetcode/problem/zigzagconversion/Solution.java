package com.zhy.leetcode.problem.zigzagconversion;

class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        int t = 2 * numRows - 2;
        for (int i = 0 ; i < numRows; i++) {
            int j = 0;
            while (true) {
                if (i == 0) {
                    int index = t * j;
                    if (index >= length) {
                        break;
                    } else {
                        stringBuilder.append(s.charAt(index));
                        j ++;
                    }
                } else if (i == numRows - 1) {
                    int index = t * j + numRows - 1;
                    if (index >= length) {
                        break;
                    } else {
                        stringBuilder.append(s.charAt(index));
                        j ++;
                    }
                } else {
                    int index1 = t * j - i;
                    if (index1 >= length) {
                        break;
                    } else if (index1 < 0) {
                    } else {
                        stringBuilder.append(s.charAt(index1));
                    }
                    int index2 = t * j + i;
                    if (index2 >= length) {
                        break;
                    } else {
                        stringBuilder.append(s.charAt(index2));
                    }
                    j ++;
                }
            }
        }
        return stringBuilder.toString();
    }

}
