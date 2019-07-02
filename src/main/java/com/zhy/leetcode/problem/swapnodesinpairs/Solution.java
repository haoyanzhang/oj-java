package com.zhy.leetcode.problem.swapnodesinpairs;

import com.zhy.leetcode.problem.node.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                return result;
            }
            ListNode nextNext = next.next;
            head.next = nextNext == null || nextNext.next == null ? nextNext : nextNext.next;
            next.next = head;
            head = nextNext;
        }
        return result;
    }
}
