package com.zhy.leetcode.contest.weeklycontest175.checkifnandtsdoubleexist;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i >> 1))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}