package com.zhy.leetcode.problem.reverselinkedlistII;

import com.zhy.leetcode.problem.node.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        m--;
        n--;
        int i = 0;
        ListNode cur = head;
        ListNode last = null;
        while (i < m) {
            last = cur;
            cur = cur.next;
            i++;
        }
        ListNode cur2 = cur.next;
        ListNode last2 = cur;
        while (i < n) {
            ListNode temp = cur2.next;
            cur2.next = last2;
            last2 = cur2;
            cur2 = temp;
            i++;
        }
        if (last == null) {
            if (cur2 != null) {
                head.next = cur2;
            } else {
                head.next = null;
            }
            return last2;
        } else {
            if (cur2 != null) {
                cur.next = cur2;
            } else {
                cur.next = null;
            }
            last.next = last2;
            return head;
        }
    }
}