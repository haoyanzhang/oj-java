package com.zhy.leetcode.problem.palindromepartitioning;


import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<List<String>> partition(String s) {

        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < isPalindrome.length; i++) {
            for (int j = 0; j + i < isPalindrome[i].length; j++) {
                if (i == 0) {
                    isPalindrome[j][i + j] = true;
                } else if(i == 1) {
                    isPalindrome[j][i + j] = chars[j] == chars[i + j];
                } else {
                    isPalindrome[j][i + j] = isPalindrome[j + 1][i+ j - 1] && chars[j] == chars[ i+ j];
                }
            }
        }

        List<List<String>>[] dp = new List[chars.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int i = 1; i < chars.length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]) {
                    List<List<String>> originList = dp[j];
                    String sub = s.substring(j, i);
                    for (List<String> strings : originList) {
                        ArrayList<String> newList = new ArrayList<>(strings);
                        newList.add(sub);
                        dp[i].add(newList);
                    }
                }
            }
        }

        return dp[dp.length - 1];
    }
}

