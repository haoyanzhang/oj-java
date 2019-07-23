package com.zhy.leetcode.problem.palindromelinkedlist;

import com.zhy.leetcode.problem.node.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i).equals(nums.get(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
