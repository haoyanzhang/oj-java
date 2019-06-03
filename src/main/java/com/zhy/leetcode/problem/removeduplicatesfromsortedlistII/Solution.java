package com.zhy.leetcode.problem.removeduplicatesfromsortedlistII;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode father = null;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (father != null) {
                    father.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            } else {
                father = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
