package com.zhy.leetcode.problem.balancedbinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {

    public boolean isBalanced(TreeNode root) {
        return buildDepthInfo(root).isBalanced;
    }

    private DepthInfo buildDepthInfo(TreeNode root) {
        if (root == null) {
            return DepthInfo.EMPTY;
        }
        DepthInfo rightDepthInfo = buildDepthInfo(root.right);
        DepthInfo leftDepthInfo = buildDepthInfo(root.left);
        if (!rightDepthInfo.isBalanced || !leftDepthInfo.isBalanced) {
            return DepthInfo.NOT_BALANCE;
        }
        DepthInfo result = new DepthInfo();
        result.maxDepth = (rightDepthInfo.maxDepth > leftDepthInfo.maxDepth
                ? rightDepthInfo.maxDepth
                : leftDepthInfo.maxDepth) + 1;
        result.minDepth = (rightDepthInfo.minDepth < leftDepthInfo.minDepth
                ? rightDepthInfo.minDepth
                : leftDepthInfo.minDepth) + 1;
        result.isBalanced = Math.abs(rightDepthInfo.maxDepth - leftDepthInfo.maxDepth) <= 1;
        return result;
    }

    private static class DepthInfo {

        private static DepthInfo EMPTY;

        private static DepthInfo NOT_BALANCE;


        static  {
            EMPTY = new DepthInfo();
            EMPTY.maxDepth = EMPTY.minDepth = -1;
            EMPTY.isBalanced = true;

            NOT_BALANCE = new DepthInfo();
            NOT_BALANCE.maxDepth = NOT_BALANCE.minDepth = -1;
            NOT_BALANCE.isBalanced = false;
        }

        private int maxDepth;

        private int minDepth;

        private boolean isBalanced;

        public int getMaxDepth() {
            return maxDepth;
        }

        public void setMaxDepth(int maxDepth) {
            this.maxDepth = maxDepth;
        }

        public int getMinDepth() {
            return minDepth;
        }

        public void setMinDepth(int minDepth) {
            this.minDepth = minDepth;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }
    }
}
