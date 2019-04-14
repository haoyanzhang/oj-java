package com.zhy.leetcode.problem.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static Map<Character, String> map;

    static {
        map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<String>();
        }
        return letterCombinations(digits, 0);
    }

    public List<String> letterCombinations(String digits, int index) {
        if (index == digits.length()) {
            ArrayList<String> result = new ArrayList<String>();
            result.add("");
            return result;
        }
        char c = digits.charAt(index);
        String s = map.get(c);
        ArrayList<String> result = new ArrayList<String>();
        List<String> list = letterCombinations(digits, index + 1);
        for (int i = 0; i < s.length(); i++) {
            for (String s1 : list) {
                result.add(s.charAt(i) + s1);
            }
        }
        return result;
    }
}
