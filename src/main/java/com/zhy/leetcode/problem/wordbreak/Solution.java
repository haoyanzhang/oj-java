package com.zhy.leetcode.problem.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return search(s, 0, new HashSet<>(wordDict), new boolean[s.length()]);

    }

    private boolean search(String s, int index, Set<String> wordDict, boolean[] visited) {

        if (index == s.length()) {
            return true;
        }

        if (visited[index]) {
            return false;
        }
        visited[index] = true;


        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (wordDict.contains(substring)) {
                if (search(s, i, wordDict, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
