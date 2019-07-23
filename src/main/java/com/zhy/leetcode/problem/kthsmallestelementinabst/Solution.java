package com.zhy.leetcode.problem.kthsmallestelementinabst;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {

    private Integer result = null;

    private Integer index = 0;

    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);
        return result;
    }

    public void travel(TreeNode treeNode, int k) {
        if (treeNode == null || result != null) {
            return;
        }
        travel(treeNode.left, k);
        index ++;
        if (index == k) {
            result = treeNode.val;
            return;
        }
        travel(treeNode.right, k);
    }
}
