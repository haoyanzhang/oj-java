package com.zhy.leetcode.problem.maximumproductsubarray;



class Solution {



    public int maxProduct(int[] nums) {
        return maxProduct(nums, 0);
    }

    public int maxProduct(int[] nums, int i) {
        if (i == nums.length) {
            return Integer.MIN_VALUE;
        }
        int firstNegativeProduct = 0;
        int untilLastNegativeProduct = 0;
        int curProduct = 1;
        int negativeCount = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 0) {
                if (j == i) {
                    return Math.max(0, maxProduct(nums, i + 1));
                }
                int result = Integer.MIN_VALUE;
                if (negativeCount % 2 == 0 || i == j - 1) {
                    result = curProduct;
                } else {
                    result = Math.max(curProduct / firstNegativeProduct, untilLastNegativeProduct);
                }
                return Math.max(0, Math.max(result, maxProduct(nums, j + 1)));
            } else if (nums[j] < 0) {
                negativeCount++;
                untilLastNegativeProduct = curProduct;
                curProduct *= nums[j];
                if (negativeCount == 1) {
                    firstNegativeProduct = curProduct;
                }
            } else {
                curProduct *= nums[j];
            }
        }
        if (negativeCount % 2 == 0 || i == nums.length - 1) {
            return curProduct;
        } else {
            return Math.max(curProduct / firstNegativeProduct, untilLastNegativeProduct);
        }
    }
}
