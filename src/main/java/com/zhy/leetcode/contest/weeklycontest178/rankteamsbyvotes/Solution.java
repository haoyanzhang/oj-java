package com.zhy.leetcode.contest.weeklycontest178.rankteamsbyvotes;

import java.util.Arrays;

class Solution {

    public String rankTeams(String[] votes) {

        if (votes.length == 0) {
            return "";
        }

        Item[] items = new Item[26];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item((char)('A' + i), votes[0].length());
        }

        for (String vote : votes) {
            char[] charArray = vote.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                items[charArray[i] - 'A'].nums[i]++;
            }
        }

        StringBuilder result = new StringBuilder();
        Arrays.sort(items);
        for (int i = 0; i < votes[0].length(); i++) {
            result.append(items[i].c);
        }
        return result.toString();
    }

    private static class Item implements Comparable<Item> {

        public Item(char c, int length) {
            this.c = c;
            this.nums = new int[length];
        }

        public int[] nums;

        public char c;


        @Override
        public int compareTo(Item o) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != o.nums[i]) {
                    return o.nums[i] - nums[i];
                }
            }
            return c - o.c;
        }
    }
}
