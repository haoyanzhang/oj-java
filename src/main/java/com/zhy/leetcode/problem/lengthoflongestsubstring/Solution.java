package com.zhy.leetcode.problem.lengthoflongestsubstring;

import java.util.HashSet;
import java.util.Set;

class Solution {


    public int lengthOfLongestSubstring(String s) {
        int pos = 0;
        int result = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(pos));
                pos++;
            }
            set.add(c);
            int size = set.size();
            result = result > size ? result : size;
        }
        return result;
    }
}
