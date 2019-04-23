package com.zhy.leetcode.problem.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, boolean[] in, List<Integer> cur, List<List<Integer>> result) {
        boolean over = true;
        for (int i = 0; i < nums.length; i++) {
            if (in[i]) {
                continue;
            } else {
                over = false;
                in[i] = true;
                cur.add(nums[i]);
                permute(nums, in, cur, result);
                cur.remove(cur.size()-1);
                in[i] = false;
            }
        }
        if (over) {
            result.add(new ArrayList<>(cur));
        }
    }
}
