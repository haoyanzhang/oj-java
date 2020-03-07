package com.zhy.leetcode.contest.biweeklycontest19.numberofsubarraysofsizeKandaveragegreaterthanorequaltothreshold;

class Solution {



    public int numOfSubarrays(int[] arr, int k, int threshold) {

        if (k > arr.length) {
            return 0;
        }

        int result = 0;
        long targetSum = k * threshold;
        long sum = 0;

        int i;
        for (i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= targetSum) {
            result++;
        }
        for (; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            if (sum >= targetSum) {
                result++;
            }
        }
        return result;
    }
}