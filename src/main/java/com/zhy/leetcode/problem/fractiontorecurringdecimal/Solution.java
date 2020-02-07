package com.zhy.leetcode.problem.fractiontorecurringdecimal;


import java.util.HashMap;

class Solution {


    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder stringBuilder = new StringBuilder();


        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            stringBuilder.append("-");
        }
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);

        stringBuilder.append(numeratorL / denominatorL);

        long curMode = numeratorL % denominatorL;
        if (curMode == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");


        HashMap<Long, Integer> map = new HashMap<>();
        map.put(curMode, stringBuilder.length());

        while (curMode != 0) {
            curMode *= 10;
            stringBuilder.append(curMode / denominatorL);
            curMode = curMode % denominatorL;
            if (map.containsKey(curMode)) {
                String s = stringBuilder.toString();
                Integer index = map.get(curMode);
                return s.substring(0, index) + "(" + s.substring(index) + ")";
            }
            map.put(curMode, stringBuilder.length());
        }

        return stringBuilder.toString();
    }
}