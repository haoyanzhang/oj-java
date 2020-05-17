package com.zhy.leetcode.problem.longestchunkedpalindromedecomposition;

class Solution {


    public int longestDecomposition(String text) {

        return longestDecomposition(text, 0);
    }

    public int longestDecomposition(String text, int start) {
        //aaabbbaaa
        int end = text.length() - start;
        int size = end - start;
        for (int length = 1; length < size; length++) {
            if (text.substring(start, start + length).equals(text.substring(end - length, end))) {
                return longestDecomposition(text, start + length) + 2;
            }
        }
        return start * 2 == text.length()? 0: 1;
    }
}