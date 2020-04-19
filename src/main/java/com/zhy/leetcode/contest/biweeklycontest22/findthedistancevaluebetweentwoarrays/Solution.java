package com.zhy.leetcode.contest.biweeklycontest22.findthedistancevaluebetweentwoarrays;

import java.util.TreeSet;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        TreeSet<Integer> integers = new TreeSet<>();
        for (int i : arr2) {
            integers.add(i);
        }

        int result = 0;
        for (int i : arr1) {
            if (!(integers.subSet(i - d, true, i + d, true).size() > 0)) {
                result++;
            }
        }

        return result;
    }
}