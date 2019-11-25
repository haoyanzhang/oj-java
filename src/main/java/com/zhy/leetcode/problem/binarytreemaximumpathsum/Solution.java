package com.zhy.leetcode.problem.binarytreemaximumpathsum;

import com.zhy.leetcode.problem.node.TreeNode;

/**
 * @author zhanghaoyan
 */
class Solution {

    public int maxPathSum(TreeNode root) {
        return findMaxPathSum(root).getMax();
    }

    public Result findMaxPathSum(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, 0);
        }
        Result rightResult = findMaxPathSum(node.right);
        Result leftResult = findMaxPathSum(node.left);
        int maxSinglePath = Math.max(Math.max(rightResult.getMaxSinglePath(), leftResult.getMaxSinglePath()), 0) + node.val;
        int newMax = Math.max(rightResult.getMaxSinglePath(), 0) + Math.max(leftResult.getMaxSinglePath(), 0) + node.val;
        int max = Math.max(Math.max(rightResult.getMax(), leftResult.getMax()), newMax);
        return new Result(max, maxSinglePath);
    }

    private static class Result {

        public Result(int max, int maxSinglePath) {
            this.max = max;
            this.maxSinglePath = maxSinglePath;
        }

        int max;

        int maxSinglePath;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMaxSinglePath() {
            return maxSinglePath;
        }

        public void setMaxSinglePath(int maxSinglePath) {
            this.maxSinglePath = maxSinglePath;
        }
    }
}
