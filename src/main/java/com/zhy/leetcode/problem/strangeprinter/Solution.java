package com.zhy.leetcode.problem.strangeprinter;

import java.util.Arrays;

class Solution {

    public int strangePrinter(String s) {

        if (s.equals("")) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int i = 1;
        int j = 0;
        while (i < chars.length) {
            if (chars[i] == chars[j]) {
                i++;
            } else {
                chars[j + 1] = chars[i];
                i++;
                j++;
            }
        }
        chars = Arrays.copyOfRange(chars, 0, j + 1);


        return dfs(chars, 0, chars.length - 1, new int[chars.length][chars.length]);
    }

    private int dfs(char[] chars, int start, int end, int[][] cache) {
        if (start > end) {
            return 0;
        }
        if (cache[start][end] != 0) {
            return cache[start][end];
        }
        int result = dfs(chars, start, end - 1, cache) + 1;
        for (int i = start; i < end - 1; i++) {
            if (chars[i] == chars[end]) {
                result = Math.min(result, dfs(chars, start, i, cache) + dfs(chars, i + 1, end - 1, cache));
            }
        }
        cache[start][end] = result;

        return result;
    }

}