package com.zhy.leetcode.problem.implementstrstr;

class Solution {


    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] kmp = new int[needle.length()];
        kmp[0] = -1;
        for (int i = 1; i < needle.length() ; i++) {
            int pos = i - 1;
            while (pos != 0 && needle.charAt(i - 1) != needle.charAt(kmp[pos])) {
                pos = kmp[pos];
            }
            kmp[i] =  kmp[pos] + 1;
        }
        int pos = 0;
        for (int i = 0; i < haystack.length();i++) {
            while (pos != -1 && needle.charAt(pos) != haystack.charAt(i)) {
                pos = kmp[pos];
            }
            pos++;
            if (pos == needle.length()) {
                return i - pos + 1;
            }
        }
        return -1;
    }
}