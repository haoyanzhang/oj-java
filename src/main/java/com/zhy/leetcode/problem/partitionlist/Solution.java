package com.zhy.leetcode.problem.partitionlist;

import com.zhy.leetcode.problem.node.ListNode;

class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode firstHead = null;
        ListNode secondHead = null;
        ListNode firstCur = null;
        ListNode secondCur = null;
        while (head != null) {
            if (head.val < x) {
                if (firstHead == null) {
                    firstHead = firstCur = head;
                } else {
                    firstCur.next = head;
                    firstCur = head;
                }
            } else {
                if (secondHead == null) {
                    secondHead = secondCur = head;
                } else {
                    secondCur.next = head;
                    secondCur = head;
                }
            }
            head = head.next;
        }
        if (firstHead == null) {
            return secondHead;
        }
        firstCur.next = secondHead;
        if (secondCur != null) {
            secondCur.next = null;
        }
        return  firstHead;
    }
}