package com.zhy.leetcode.problem.maximumdepthofbinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return max(maxDepth(root.right), maxDepth(root.left)) + 1;

    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
