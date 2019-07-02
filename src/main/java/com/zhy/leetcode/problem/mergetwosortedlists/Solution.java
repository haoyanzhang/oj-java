package com.zhy.leetcode.problem.mergetwosortedlists;

import com.zhy.leetcode.problem.node.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head;
        ListNode cur;
        if (l1.val < l2.val) {
            cur = head = l1;
            l1 = l1.next;
        } else {
            cur = head = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return head;
    }
}
