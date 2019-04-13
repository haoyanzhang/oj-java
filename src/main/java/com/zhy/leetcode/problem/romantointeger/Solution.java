package com.zhy.leetcode.problem.romantointeger;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static Map<Character, Integer> map;

    static  {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if (i + 1 == s.length() || map.get(s.charAt(i + 1)) <= value) {
                sum += value;
            } else {
                sum += map.get(s.charAt(i + 1)) - value;
                i++;
            }
        }
        return sum;
    }
}
