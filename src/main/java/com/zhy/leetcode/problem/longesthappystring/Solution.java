package com.zhy.leetcode.problem.longesthappystring;

class Solution {

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder stringBuilder = new StringBuilder();

        char lastChar = '\0';
        int lastNum = 0;
        while (a + b + c > 0) {
            if (a >= b && a >= c && a > 0) {
                if (lastChar != 'a' || lastNum < 2) {
                    stringBuilder.append("a");
                    a--;
                    if (lastChar == 'a') {
                        lastNum++;
                    } else {
                        lastChar = 'a';
                        lastNum = 1;
                    }
                } else {
                    if (b >= c && b > 0) {
                        stringBuilder.append("b");
                        lastChar = 'b';
                        lastNum = 1;
                        b--;
                    } else if (c >= b && c > 0) {
                        stringBuilder.append("c");
                        lastChar = 'c';
                        lastNum = 1;
                        c--;
                    } else {
                        return stringBuilder.toString();
                    }
                }
            } else if (b >= a && b >= c && b > 0) {
                if (lastChar != 'b' || lastNum < 2) {
                    stringBuilder.append("b");
                    b--;
                    if (lastChar == 'b') {
                        lastNum++;
                    } else {
                        lastChar = 'b';
                        lastNum = 1;
                    }
                } else {
                    if (a >= c && a > 0) {
                        stringBuilder.append("a");
                        lastChar = 'a';
                        lastNum = 1;
                        a--;
                    } else if (c >= a && c > 0) {
                        stringBuilder.append("c");
                        lastChar = 'c';
                        lastNum = 1;
                        c--;
                    } else {
                        return stringBuilder.toString();
                    }
                }
            } else if (c >= a && c >= b && c > 0) {
                if (lastChar != 'c' || lastNum < 2) {
                    stringBuilder.append("c");
                    c--;
                    if (lastChar == 'c') {
                        lastNum++;
                    } else {
                        lastChar = 'c';
                        lastNum = 1;
                    }
                } else {
                    if (a >= b && a > 0) {
                        stringBuilder.append("a");
                        lastChar = 'a';
                        lastNum = 1;
                        a--;
                    } else if (b >= a && b > 0){
                        stringBuilder.append("b");
                        lastChar = 'b';
                        lastNum = 1;
                        b--;
                    } else {
                        return stringBuilder.toString();
                    }
                }
            } else {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }
}