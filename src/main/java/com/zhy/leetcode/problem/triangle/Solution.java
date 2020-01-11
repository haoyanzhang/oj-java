package com.zhy.leetcode.problem.triangle;

import java.util.List;

class Solution {



    public int minimumTotal(List<List<Integer>> triangle) {

        int[] sums = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                Integer value = row.get(j);
                sums[j] = Math.min(sums[j], sums[j+1]) + value;
            }
        }

        return sums[0];

    }
}
