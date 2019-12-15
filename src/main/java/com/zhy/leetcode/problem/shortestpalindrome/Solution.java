package com.zhy.leetcode.problem.shortestpalindrome;

import java.util.Arrays;

/**
 * @author zhanghaoyan
 */
class Solution {

    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int[] next = buildNext(s);

        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (j >= 0) {
            if (i == -1 || chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                i = next[i];
            }
        }

        char[] subChars = s.substring(i).toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i1 = subChars.length - 1; i1 >= 0; i1--) {
            stringBuilder.append(subChars[i1]);
        }

        return stringBuilder.append(s).toString();
    }

    private int[] buildNext(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        int i = 1;
        int k = -1;
        while (i < next.length) {
            if (k == -1 || chars[k] == chars[i-1]) {
                k++;
                next[i++] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
