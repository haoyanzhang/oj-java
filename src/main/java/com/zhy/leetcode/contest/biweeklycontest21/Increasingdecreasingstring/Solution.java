package com.zhy.leetcode.contest.biweeklycontest21.Increasingdecreasingstring;

class Solution {

    public String sortString(String s) {

        int[] nums = new int[26];

        for (char c : s.toCharArray()) {

            nums[c - 'a']++;
        }

        int remain = s.length();

        StringBuilder stringBuilder = new StringBuilder();

        while (remain > 0) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    stringBuilder.append((char)( 'a' + i));
                    nums[i]--;
                    remain--;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > 0) {
                    stringBuilder.append((char)( 'a' + i));
                    nums[i]--;
                    remain--;
                }
            }
        }
        return stringBuilder.toString();
    }
}
