package com.zhy.leetcode.contest.weeklycontest177.largestmultipleofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestMultipleOfThree(int[] digits) {

        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int digit : digits) {
            int mod = digit % 3;
            if (mod == 0) {
                r.add(digit);
            } else if (mod == 1) {
                l1.add(digit);
            }
            else if (mod == 2) {
                l2.add(digit);
            }
        }
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        l2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int index1;
        int index2;
        index1 = index2 = Math.min(l1.size(), l2.size());
        while (index1 + 3 <= l1.size()) {
            index1 += 3;
        }
        while (index2 + 3 <= l2.size()) {
            index2 += 3;
        }
        if (index1 > 0 && l1.size() - index1 == 0 && l2.size() - index2 == 2) {
            index1--;
            index2+=2;
        }if (index2 > 0 && l2.size() - index2 == 0 && l1.size() - index1 == 2) {
            index2--;
            index1+=2;
        }
        for (int i = 0; i < index1; i++) {
            r.add(l1.get(i));
        }for (int i = 0; i < index2; i++) {
            r.add(l2.get(i));
        }

        r.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (r.isEmpty()) {
            return "";
        } else if (r.get(0) == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : r) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
