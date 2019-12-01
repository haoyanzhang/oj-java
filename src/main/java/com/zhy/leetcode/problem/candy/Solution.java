package com.zhy.leetcode.problem.candy;

/**
 * @author zhanghaoyan
 */

class Solution {

    public int candy(int[] ratings) {

        int[] sumN = new int[ratings.length];
        sumN[0] = 1;

        int index = 0;
        int res = 0;
        int lastWave = Integer.MAX_VALUE;
        while (index != ratings.length) {
            if (index-1 >=0 && ratings[index] == ratings[index-1]) {
                lastWave = Integer.MAX_VALUE;
            }
            int min = findNextMin(ratings, index);
            int minLength = min - index;
            res += sumN(minLength, sumN);
            if (minLength > lastWave) {
                res += minLength - lastWave;
            }
            if (min + 1 != ratings.length && ratings[min + 1] == ratings[min]) {
                lastWave = Integer.MAX_VALUE;
                index = min + 1;
                continue;
            }
            int max = findNextMax(ratings, min);
            int maxLength = max - min;
            res += sumN(maxLength, sumN) - 1;
            lastWave = maxLength - 1;
            index = max + 1;
        }
        return res;
    }

    private int findNextMin(int[] ratings, int start) {
        while (start + 1 != ratings.length && ratings[start + 1] < ratings[start]) {
            start++;
        }
        return start;
    }

    private int findNextMax(int[] ratings, int start) {
        while (start + 1 != ratings.length && ratings[start + 1] > ratings[start]) {
            start++;
        }
        return start;
    }

    private int sumN(int n, int[] cache) {
        if (cache[n] == 0) {
            return cache[n] = sumN(n - 1, cache) + n + 1;
        }
        return cache[n];
    }
}
