package com.zhy.leetcode.problem._3sum;

import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = - nums[i] - nums[j];
                if (find(nums, j + 1, nums.length, target)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    result.add(list);
                }
                while (j + 1 < nums.length && nums[j+1
                        ] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return result;
     }

    private boolean find(int[] nums, int from, int to, int target) {
        if (from >= nums.length || nums[from] > target || nums[to-1] < target) {
            return false;
        }
        if (to - from < 4) {
            for (int i = from ; i < to; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
        int mid = ((to - from) >> 1) + from;
        if (nums[mid] > target) {
            return find(nums, from, mid, target);
        } else {
            return find(nums, mid, to, target);
        }
    }
}
