package com.zhy.leetcode.problem.restoreIPaddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                if (isUnderCharValue(s, i-j, i)) {
                    String value = s.substring(i - j, i);
                    for (List<String> l : dp[i - j]) {
                        if (l.size() < 4) {
                            ArrayList<String> copy = new ArrayList<>(l);
                            copy.add(value);
                            dp[i].add(copy);
                        }
                    }
                }
            }
        }
        return dp[s.length()].stream()
                .filter(list -> list.size() == 4)
                .map(list -> list.get(0) + "." + list.get(1)
                        + "." + list.get(2) + "." + list.get(3))
                .collect(Collectors.toList());

    }

    private boolean isUnderCharValue(String s, int start, int end) {
        if (start < 0 || start >= s.length() || end > s.length()) {
            return false;
        }
        if (end - start == 1) {
            return true;
        }
        if (end - start == 2) {
            return s.charAt(start) != '0';
        }
        if (end - start > 3) {
            return false;
        }
        return s.charAt(start) == '1' || s.charAt(start) == '2' && (s.charAt(start + 1) <= '4' || s.charAt(start + 1) == '5' && s.charAt(start + 2) <= '5');
    }
}
