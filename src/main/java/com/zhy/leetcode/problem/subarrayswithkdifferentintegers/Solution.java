package com.zhy.leetcode.problem.subarrayswithkdifferentintegers;

import java.util.HashMap;

class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int key1 = 0;
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int key2 = 0;
        int j = 0;
        int k = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (map1.containsKey(A[i])) {
                map1.put(A[i], map1.get(A[i]) + 1);
            } else {
                map1.put(A[i], 1);
                key1++;
            }
            if (map2.containsKey(A[i])) {
                map2.put(A[i], map2.get(A[i]) + 1);
            } else {
                map2.put(A[i], 1);
                key2++;
            }
            while (key1 > K) {
                map1.put(A[j], map1.get(A[j]) - 1);
                if (map1.get(A[j]) == 0) {
                    map1.remove(A[j]);
                    key1--;
                }
                j++;
            }
            while (key2 >= K) {
                map2.put(A[k], map2.get(A[k]) - 1);
                if (map2.get(A[k]) == 0) {
                    map2.remove(A[k]);
                    key2--;
                }
                k++;
            }
            if (key1 == K) {
                result += k - j;
            }
        }
        return result;
    }

}