package com.zhy.leetcode.problem.flattenbinarytreetolinkedlist;

import com.zhy.leetcode.problem.node.TreeNode;

/**
 * @author zhanghaoyan
 */
class Solution {

    public void flatten(TreeNode root) {
        flattenAndReturnLast(root);
    }

    private TreeNode flattenAndReturnLast(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        TreeNode leftLast = flattenAndReturnLast(left);
        TreeNode rightLast = flattenAndReturnLast(right);
        if (leftLast != null) {
            node.right = left;
            leftLast.right = right;
        }
        return rightLast != null? rightLast: leftLast != null? leftLast: node;
    }
}
