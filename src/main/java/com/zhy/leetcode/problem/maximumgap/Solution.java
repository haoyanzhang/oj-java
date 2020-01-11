package com.zhy.leetcode.problem.maximumgap;

import java.util.Arrays;

class Solution {


    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return  0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] > nums[i+1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            } else {
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        if (nums.length % 2 == 1) {
            max = Math.max(max, nums[nums.length - 1]);
            min = Math.min(min, nums[nums.length - 1]);
        }

        if (max == min) {
            return 0;
        }

        int bucketSize = (max - min) / (nums.length - 1);

        if (bucketSize == 0) {
            bucketSize = 1;
        }

        Bucket[] buckets = new Bucket[nums.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (index >= buckets.length) {
                index = buckets.length - 1;
            }
            buckets[index].put(num);
        }

        int result = Integer.MIN_VALUE;
        Bucket last = null;
        for (Bucket bucket : buckets) {
            if (last == null || bucket.empty()) {
                if (!bucket.empty()) {
                    last = bucket;
                }
                continue;
            }
            result = Math.max(result, bucket.getMin() - last.getMax());
            last = bucket;
        }

        return result;

    }

    private static class Bucket {

        private Integer max = null;

        private Integer min = null;

        public boolean empty() {
            return max == null;
        }

        public void put(Integer i) {
            if (empty()) {
                max = min = i;
            } else {
                if (i > max) {
                    max = i;
                } else if(i < min) {
                    min = i;
                }
            }
        }

        public Integer getMax() {
            return max;
        }

        public Integer getMin() {
            return min;
        }
    }
}
