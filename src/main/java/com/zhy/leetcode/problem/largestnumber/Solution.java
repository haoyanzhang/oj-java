package com.zhy.leetcode.problem.largestnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    public String largestNumber(int[] nums) {

        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).equals("0") && stringBuilder.length() == 0)) {
                stringBuilder.append(list.get(i));
            }
        }
        String result = stringBuilder.toString();
        return result.length() > 0? result: "0";
    }
}