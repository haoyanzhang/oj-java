package com.zhy.leetcode.problem.removenthnodefromendoflist;


import com.zhy.leetcode.problem.node.ListNode;

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] queue = new ListNode[n + 1];
        int pos = 0;
        ListNode cur = head;
        while (cur != null) {
            queue[pos] = cur;
            pos++;
            if (pos == n + 1) {
                pos = 0;
            }
            cur = cur.next;
        }
        ListNode last = queue[pos];
        if (last == null) {
            return head.next;
        }
        last.next = n == 1 ? null : pos + 2 >= n + 1 ? queue[pos + 2 - n - 1] : queue[pos + 2];
        return head;
    }
}