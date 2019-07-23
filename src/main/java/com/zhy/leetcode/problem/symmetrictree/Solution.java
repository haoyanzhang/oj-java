package com.zhy.leetcode.problem.symmetrictree;



class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        return (node1 == null && node2 == null)
                || (node1 != null && node2 != null && node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }
}
