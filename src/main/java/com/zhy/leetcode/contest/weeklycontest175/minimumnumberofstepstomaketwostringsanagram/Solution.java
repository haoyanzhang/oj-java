package com.zhy.leetcode.contest.weeklycontest175.minimumnumberofstepstomaketwostringsanagram;


import java.util.HashMap;

class Solution {
    public int minSteps(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.containsKey(c)) {
                    Integer num = map.get(c);
                    if (num == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, num - 1);
                    }
                }
            }
        }

        return map.values().stream().mapToInt(i -> i).sum();
    }
}
