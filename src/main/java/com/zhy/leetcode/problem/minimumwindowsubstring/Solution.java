package com.zhy.leetcode.problem.minimumwindowsubstring;

import java.util.HashSet;

class Solution {
    public String minWindow(String s, String t) {
        HashSet<Character> tChars = new HashSet<>();
        int[] tCharNumArray = new int[256];
        int tCharNum = 0;
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            tChars.add(c);
            tCharNumArray[c]++;
            tCharNum++;
        }
        int[] sCharNumArray = new int[256];
        int sCharNum = 0;
        int sStart = 0;
        int sEnd = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        while (true) {
            while (sCharNum != tCharNum && sEnd < s.length()) {
                char c = s.charAt(sEnd);
                if (tChars.contains(c)) {
                    if (sCharNumArray[c] < tCharNumArray[c]) {
                        sCharNum++;
                        sCharNumArray[c]++;
                    } else {
                        sCharNumArray[c]++;
                    }
                }
                sEnd++;
            }
            if (sCharNum == tCharNum) {
                while (true) {
                    char c = s.charAt(sStart);
                    if (tChars.contains(c)) {
                        if (sCharNumArray[c] == tCharNumArray[c]) {
                            break;
                        } else {
                            sCharNumArray[c]--;
                        }
                    }
                    sStart++;
                }
                if (sEnd - sStart < minLength) {
                    minLength = sEnd - sStart;
                    minStart = sStart;
                    minEnd = sEnd;
                }
            } else {
                return s.substring(minStart, minEnd);
            }
            sCharNumArray[s.charAt(sStart)]--;
            sCharNum--;
            sStart++;
        }
    }
}
