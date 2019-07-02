package com.zhy.leetcode.problem.reversenodesinkgroup;

import com.zhy.leetcode.problem.node.ListNode;

import java.util.Arrays;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode cur = null;
        ListNode[] nodes = new ListNode[k];
        while (head != null) {
            Arrays.fill(nodes, null);
            int pos = 0;
            ListNode current = head;
            while (current != null && pos < k) {
                nodes[pos] = current;
                current = current.next;
                pos ++;
            }
            ListNode first = null;
            ListNode firstCur = null;
            if (nodes[k- 1] == null) {
                if (cur != null) {
                    cur.next = nodes[0];
                } else {
                    result = nodes[0];
                }
                break;
            } else {
                for (int i = k - 1; i >= 0; i--) {
                    if (first == null) {
                        firstCur = first = nodes[i];
                        head = first.next;
                    } else {
                        firstCur.next = nodes[i];
                        firstCur = firstCur.next;
                    }
                }
            }
            if (cur != null) {
                cur.next = first;
            } else {
                result = first;
            }
            cur = nodes[0];
            cur.next = null;
        }
        return result;
    }
}
