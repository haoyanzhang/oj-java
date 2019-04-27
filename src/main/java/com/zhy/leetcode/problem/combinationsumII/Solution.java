package com.zhy.leetcode.problem.combinationsumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Numbers> bfs = new ArrayList<>();
        bfs.add(new Numbers());
        for (int i = candidates.length-1; i>=0; i--) {
            List<Numbers> nextBfs = new ArrayList<>();
            int dup = 1;
            int j = i-1;
            while (j >= 0 && candidates[j] == candidates[i]) {
                dup++;
                j--;
            }
            for (Numbers bf : bfs) {
                nextBfs.add(new Numbers(bf));
                for (int k = 1; k <= dup; k++) {
                    if (bf.sum + k * candidates[i] < target) {
                        Numbers numbers = new Numbers(bf);
                        numbers.setSum(numbers.getSum() + k * candidates[i]);
                        for (int l = 0; l < k; l ++) {
                            numbers.getNums().add(candidates[i]);
                        }
                        nextBfs.add(numbers);
                    } else if (bf.sum + k * candidates[i] == target) {
                        Numbers numbers = new Numbers(bf);
                        for (int l = 0; l < k; l ++) {
                            numbers.getNums().add(candidates[i]);
                        }
                        result.add(numbers.nums);
                    }
                }
            }
            i -= dup - 1;
            bfs = nextBfs;
        }
        return result;
    }

    private static class Numbers{

        Numbers() {
            sum = 0;
            nums = new ArrayList<>();
        }

        Numbers(Numbers other) {
            sum = other.sum;
            nums = new ArrayList<>();
            nums.addAll(other.nums);
        }

        int sum;

        List<Integer> nums;

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public List<Integer> getNums() {
            return nums;
        }

        public void setNums(List<Integer> nums) {
            this.nums = nums;
        }
    }

}
