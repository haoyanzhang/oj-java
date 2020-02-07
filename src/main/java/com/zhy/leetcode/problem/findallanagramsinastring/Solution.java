package com.zhy.leetcode.problem.findallanagramsinastring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            if(pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) + 1);
            } else {
                pMap.put(c, 1);
            }
        }

        int numC = pMap.size();
        int currentLength = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        int same = 0;
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            char c = sCharArray[i];
            if (currentLength >= p.length()) {
                Character t = sCharArray[i - p.length()];
                Integer num = sMap.get(t);
                if (num.equals(pMap.getOrDefault(t, 0))) {
                    same--;
                }
                if (num - 1 != 0 && num - 1 == pMap.getOrDefault(t, 0)) {
                    same++;
                }
                if (num - 1 == 0) {
                    sMap.remove(t);
                } else {
                    sMap.put(t, num - 1);
                }
            }
            int newNum;
            if (sMap.containsKey(c)) {
                newNum = sMap.get(c) + 1;
            } else {
                newNum = 1;
            }
            if (newNum == pMap.getOrDefault(c, 0)) {
                same++;
            } if (newNum - 1 != 0 && newNum - 1 == pMap.getOrDefault(c, 0)) {
                same--;
            }
            sMap.put(c, newNum);
            if (same == numC) {
                result.add(i - p.length() + 1);
            }
            currentLength++;
        }

        return result;
    }
}