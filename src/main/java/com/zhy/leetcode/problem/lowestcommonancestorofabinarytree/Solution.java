package com.zhy.leetcode.problem.lowestcommonancestorofabinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            return root;
        } else if (leftNode == null) {
            return rightNode;
        } else if (rightNode == null) {
            return leftNode;
        } else {
            return root;
        }
    }
}
