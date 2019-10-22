package com.zhy.leetcode.problem.pathsum;

import com.zhy.leetcode.problem.node.TreeNode;

/**
 * @author zhanghaoyan
 */
class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if(root.right == null && root.left == null && root.val == sum) {
            return true;
        }
        int nextSum = sum - root.val;
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}
