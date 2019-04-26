package com.zhy.leetcode.problem.permutationsequence;

class Solution {

    private static int[] factorial = new int[]{Integer.MAX_VALUE, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        StringBuilder stringBuilder = new StringBuilder();
        k--;
        while (n > 0) {
            int index = k / factorial[n - 1];
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    if (index == 0) {
                        stringBuilder.append(i);
                        used[i] = true;
                        break;
                    }
                    index--;
                }
            }
            k = k % factorial[n-1];
            n--;
        }
        return stringBuilder.toString();
    }
}
