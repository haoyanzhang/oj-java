package com.zhy.leetcode.problem.groupanagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> index = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            Integer hash = 1;
            for (char c : chars) {
                hash = hash * 26 + c;
            }
            List<String> list = index.get(hash);
            if (list == null) {
                list = new ArrayList<>();
                index.put(hash, list);
                result.add(list);
            }
            list.add(str);
        }
        return result;
    }
}
