package com.zhy.leetcode.problem.missingnumber;

import java.util.Arrays;
import java.util.stream.LongStream;

class Solution {


    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums)
                .sum();
        long sum1 = LongStream.range(0, nums.length + 1)
                .sum();
        return (int)sum1 - sum;
    }
}
