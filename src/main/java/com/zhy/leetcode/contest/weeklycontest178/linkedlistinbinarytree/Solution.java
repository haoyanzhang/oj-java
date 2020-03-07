package com.zhy.leetcode.contest.weeklycontest178.linkedlistinbinarytree;

import com.zhy.leetcode.problem.node.ListNode;
import com.zhy.leetcode.problem.node.TreeNode;

class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (head == null && root == null) {
            return true;
        }
        return isOk(head, root);

    }

    private boolean isOk(ListNode head, TreeNode root) {

        if (root == null) {
            return false;
        }

        return isCurOk(head, root) || isOk(head, root.left) || isOk(head, root.right);
    }

    private boolean isCurOk(ListNode curListNode, TreeNode curTreeNode) {

        if (curListNode == null) {
            return true;
        }
        if (curTreeNode == null) {
            return false;
        }
        if (curListNode.val != curTreeNode.val) {
            return false;
        }
        return isCurOk(curListNode.next, curTreeNode.left) || isCurOk(curListNode.next, curTreeNode.right);
    }
}
