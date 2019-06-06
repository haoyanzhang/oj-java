package com.zhy.leetcode.problem.interleavingstring;

class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    public boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int index3) {
        boolean inRange1 = index1 < s1.length();
        boolean inRange2 = index2 < s2.length();
        boolean inRange3 = index3 < s3.length();
        if (!inRange1 && !inRange2 && !inRange3) {
            return true;
        } else if (!inRange1) {
            return inRange2 && inRange3 && s2.charAt(index2) == s3.charAt(index3)
                    && isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
        } else if (!inRange2) {
            return inRange1 && inRange3 && s1.charAt(index1) == s3.charAt(index3)
                    && isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1);
        } else {
            return inRange3 && ((s1.charAt(index1) == s3.charAt(index3) && isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1))
                || (s2.charAt(index2) == s3.charAt(index3) && isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1)));
        }
    }
}