package com.zhy.leetcode.problem.removeduplicateletters;

import java.util.*;

class Solution {

    public String removeDuplicateLetters(String s) {
        if (s.equals("")) {
            return "";
        }
        int[] charNum = new int[26];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charNum[chars[i] - 'a']++;
        }

        int removePos = -1;
        for (int i = 0; i < chars.length; i++) {
            if (removePos == -1 || chars[i] < chars[removePos]) {
                removePos = i;
            }
            charNum[chars[i] - 'a']--;
            if (charNum[chars[i] - 'a'] == 0) {
                break;
            }
        }
        return chars[removePos] + removeDuplicateLetters(s.substring(removePos + 1).replaceAll(String.valueOf(chars[removePos]), ""));
    }
}
