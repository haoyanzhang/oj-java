package com.zhy.leetcode.contest.biweeklycontest21.findthelongestsubstringcontainingvowelsinevencounts.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);
    }

    public int findTheLongestSubstring(String s) {
        int[] data = new int[s.length()];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                data[i] = map.get(charArray[i]);
            } else {
                data[i] = 0;
            }
        }
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            if (i != 0 && data[i - 1] == 0) {
                continue;
            }
            for (int j = i; j < dp.length && dp.length - i + 1 >= result; j++) {
                dp[j] = i == j? data[i]: (dp[j-1] ^ data[j]);
                if (dp[j] == 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

}
