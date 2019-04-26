package com.zhy.leetcode.problem.rotatelist;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        k = length - (k % length);
        cur.next = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;

    }
}
