package com.zhy.leetcode.problem.sametree;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null)
                || (p != null && q != null && p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left));
    }
}
