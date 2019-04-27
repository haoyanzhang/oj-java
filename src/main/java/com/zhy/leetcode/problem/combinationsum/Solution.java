package com.zhy.leetcode.problem.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Numbers> bfs = new ArrayList<>();
        bfs.add(new Numbers());
        for (int i = candidates.length-1; i>=0; i--) {
            List<Numbers> nextBfs = new ArrayList<>();
            for (Numbers bf : bfs) {
                nextBfs.add(new Numbers(bf));
                int j = 0;
                while (true) {
                    j++;
                    if (bf.sum + j * candidates[i] < target) {
                        Numbers numbers = new Numbers(bf);
                        numbers.setSum(numbers.getSum() + j * candidates[i]);
                        for (int k = 0; k < j; k++) {
                            numbers.getNums().add(candidates[i]);
                        }
                        nextBfs.add(numbers);
                    } else if (bf.sum + j * candidates[i] == target) {
                        Numbers numbers = new Numbers(bf);
                        for (int k = 0; k < j; k++) {
                            numbers.getNums().add(candidates[i]);
                        }
                        result.add(numbers.nums);
                    } else {
                        break;
                    }
                }
            }
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
