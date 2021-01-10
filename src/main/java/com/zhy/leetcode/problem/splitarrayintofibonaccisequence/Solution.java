package com.zhy.leetcode.problem.splitarrayintofibonaccisequence;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (check(S, i, j, result, 0)) {
                    List<Integer> s = new ArrayList<>();
                    int last = 0;
                    for (int r : result) {
                        if (r == 0) {
                            break;
                        }
                        s.add(Integer.valueOf(S.substring(last, r)));
                        last = r;
                    }
                    return s;
                }
            }
        }

        return new ArrayList<>();
    }

    public boolean check(String s, int i, int j, int[] result, int resultPos) {
        if (s.length() - i - j < Math.max(i, j)) {
            return false;
        }
        if ((s.charAt(i) == '0' && j != 1)|| (s.charAt(0) == '0' && i != 1)) {
            return false;
        }
        Integer a = parseInt(s.substring(0, i));
        Integer b = parseInt(s.substring(i, i + j));
        if (a == null || b == null) {
            return false;
        }
        result[resultPos++] = i;
        result[resultPos++] = i + j;
        return check0(s, i + j, a + b, b, result, resultPos);
    }

    public boolean check0(String s, int start, int sum, int last, int[] result, int resultPos) {
        if (start == s.length()) {
            return true;
        }
        if (s.charAt(0) == 0) {
            if (sum == 0) {
                result[resultPos++] = 0;
                return check0(s, start + 1, 0, 0, result, resultPos);
            }
            return false;
        }
        int length = 1;
        int temp = sum;
        while (temp >= 10) {
            length++;
            temp /= 10;
        }
        if (start + length > s.length()) {
            return false;
        }
        Integer i = parseInt(s.substring(start, start + length));
        if (i == null || i != sum) {
            return false;
        }
        result[resultPos++] = start + length;
        return check0(s, start + length, i + last, i, result, resultPos);
    }

    private Integer parseInt(String s) {
        if(s.length() > 11) {
            return null;
        }
        long l = Long.parseLong(s);
        if (l > Integer.MAX_VALUE) {
            return null;
        }
        return Integer.parseInt(s);
    }
}
