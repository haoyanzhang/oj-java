package com.zhy.leetcode.problem.graycode;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int value = 1;
        while (n > 0) {
            n--;
            int size = result.size();
            for (int i = size - 1; i >= 0; i--) {
                result.add(result.get(i) + value);
            }
            value = value << 1;
        }
        return result;
    }
}