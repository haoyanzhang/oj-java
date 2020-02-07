package com.zhy.leetcode.problem.productofarrayexceptself;



class Solution {


    public int[] productExceptSelf(int[] nums) {

        int[] front = new int[nums.length];
        int[] end = new int[nums.length];
        front[0] = nums[0];
        end[end.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < front.length; i++) {
            front[i] = front[i - 1] * nums[i];
            end[end.length - 1 - i] = end[end.length - i] * nums[end.length - 1 - i];
        }


        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i >= 1? front[i - 1]: 1) * (i < end.length - 1? end[i + 1]: 1);
        }

        return result;
    }
}
