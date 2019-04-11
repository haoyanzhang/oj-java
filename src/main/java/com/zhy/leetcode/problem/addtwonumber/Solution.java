package com.zhy.leetcode.problem.addtwonumber;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        boolean carry = false;
        ListNode head = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val + (carry ? 1 : 0);
            carry = result >= 10;
            result = result % 10;
            if (head == null) {
                head = cur =  new ListNode(result);
            } else {
                cur.next = new ListNode(result);
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 == null ? l2 : l1;
        while (carry) {
            if (remain == null) {
                cur.next = new ListNode(1);
                cur = cur.next;
                carry = false;
            } else {
                int result = remain.val + 1;
                carry = result == 10;
                cur.next = new ListNode(result % 10);
                remain = remain.next;
                cur = cur.next;
            }
        }
        cur.next = remain;
        return head;
    }
}
