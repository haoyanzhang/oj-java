package com.zhy.leetcode.problem.convertsortedlisttobinarysearchtree;

import com.zhy.leetcode.problem.node.ListNode;
import com.zhy.leetcode.problem.node.TreeNode;

class Solution {


    public TreeNode sortedListToBST(ListNode head) {
        int size = size(head);
        if (size == 0) {
            return null;
        }
        int mid = size >> 1;
        ListNode midListNode;
        if (mid > 0) {
            ListNode preMidListNode = find(head, mid - 1);
            midListNode = preMidListNode.next;
            preMidListNode.next = null;
        } else {
            midListNode = head;
            head = null;
        }

        TreeNode treeNode = new TreeNode(midListNode.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(midListNode.next);
        return treeNode;
    }

    private int size(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    private ListNode find(ListNode head, int index) {
        while (index-- > 0) {
            head = head.next;
        }
        return head;
    }
}
