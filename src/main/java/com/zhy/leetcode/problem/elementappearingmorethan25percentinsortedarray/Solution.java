package com.zhy.leetcode.problem.elementappearingmorethan25percentinsortedarray;


class Solution {


    public int findSpecialInteger(int[] arr) {

        int targetNum = arr.length / 4 + 1;

        int i = 0;
        while (i < arr.length) {


            if (i + targetNum - 1 < arr.length && arr[i] == arr[i + targetNum - 1]) {
                return arr[i];
            }

            i = findFirst(arr, i, i + targetNum - 1, arr[i + targetNum - 1]);

        }

        return 0;
    }

    public int findFirst(int[] arr, int from, int to, int target) {
        if (from == to) {
            if (arr[from] == target) {
                return from;
            }
            return from + 1;
        }
        int mid = (from + to) >> 1;
        if (target > arr[mid]) {
            return findFirst(arr, mid + 1, to, target);
        } else {
            return findFirst(arr, from, mid, target);
        }
    }

}


