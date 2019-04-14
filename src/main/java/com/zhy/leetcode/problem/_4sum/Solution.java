package com.zhy.leetcode.problem._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                int ijSum = nums[i] + nums[j];
                while (k < l) {
                    int sum = ijSum + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                    }
                    if (sum > target) {
                        while (l - 1 > k && nums[l - 1] == nums[l]) {
                            l--;
                        }
                        l--;
                    } else {
                        while (k + 1 < l && nums[k + 1] == nums[k]) {
                            k++;
                        }
                        k++;
                    }
                }
                while (j + 1< nums.length && nums[j + 1] == nums[j]) {
                    j ++;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i ++;
            }
        }
        return result;
    }
}
