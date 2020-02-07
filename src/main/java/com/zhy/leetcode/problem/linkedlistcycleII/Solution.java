package com.zhy.leetcode.problem.linkedlistcycleII;

import com.zhy.leetcode.problem.node.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode quick = head;
        ListNode slow = head;
        int i = 0;
        while (quick != null) {
            quick = quick.next;
            if (quick == null) {
                break;
            }
            quick = quick.next;
            slow = slow.next;
            i++;
            if (quick == slow) {
                int j = 0;
                ListNode a = slow;
                ListNode b = head;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }
}
