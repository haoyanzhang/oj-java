package com.zhy.leetcode.problem.longestconsecutivesequence;

import java.util.HashMap;

/**
 * @author zhanghaoyan
 */
class Solution {


    public int longestConsecutive(int[] nums) {
        Integer maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            Integer next = map.get(num + 1);
            Integer last = map.get(num - 1);
            next = next == null? 0: next;
            last = last == null? 0: last;
            int length = next + last + 1;
            map.put(num, length);
            map.put(num + next, length);
            map.put(num - last, length);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
