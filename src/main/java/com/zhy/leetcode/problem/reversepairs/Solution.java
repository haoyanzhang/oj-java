package com.zhy.leetcode.problem.reversepairs;


import java.util.Arrays;

class Solution {


    public int reversePairs(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int res = 0;

        BinaryIndexTree binaryIndexTree = new BinaryIndexTree(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            int bound = nums[i] > 0? (nums[i] - 1) / 2: nums[i] == 0? -1: (nums[i] - 2) / 2;
            int index = findLastLessThanOrEquals(copy, bound);
            if (index >= 0) {
                res += binaryIndexTree.getSum(index);
            }
            binaryIndexTree.update(findLastLessThanOrEquals(copy, nums[i]), 1);
        }

        return res;
    }

    private int findLastLessThanOrEquals(int[] nums, int bound) {
        return findLastLessThanOrEquals(nums, bound, 0, nums.length);
    }

    private int findLastLessThanOrEquals(int[] nums, int bound, int from, int to) {
        if (to - from <= 1) {
            return nums[from] > bound? from - 1: from;
        }
        int mid = (to - from) / 2 + from;
        if (nums[mid] > bound) {
            return findLastLessThanOrEquals(nums, bound, from, mid);
        } else {
            return findLastLessThanOrEquals(nums, bound, mid, to);
        }

    }

    private static class BinaryIndexTree {

        public BinaryIndexTree(int l) {
            data = new long[l + 1];
        }

        long[] data;

        private int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, long k) {
            i++;
            while (i < data.length) {
                data[i] += k;
                i += lowBit(i);
            }
        }

        public long getSum(int i) {
            i++;
            int res = 0;
            while (i > 0) {
                res +=data[i];
                i -= lowBit(i);
            }
            return res;
        }
    }
}
