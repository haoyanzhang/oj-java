package com.zhy.leetcode.problem.reconstructa2Rowbinarymatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        result.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        result.add(row2);
        long count = Arrays.stream(colsum).filter(i -> i == 2).count();
        upper -= count;
        lower -= count;
        for (int i : colsum) {
            if (i == 2) {
                row1.add(1);
                row2.add(1);
            } else if (i == 1) {
                if (upper > 0) {
                    row1.add(1);
                    row2.add(0);
                    upper--;
                } else {
                    row2.add(1);
                    row1.add(0);
                    lower--;
                }
            } else {
                row1.add(0);
                row2.add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        return result;
    }
}
