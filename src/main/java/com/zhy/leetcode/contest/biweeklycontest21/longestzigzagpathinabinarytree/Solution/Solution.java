package com.zhy.leetcode.contest.biweeklycontest21.longestzigzagpathinabinarytree.Solution;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {
    public int longestZigZag(TreeNode root) {
        return longest(root).max - 1;
    }

    public Result longest(TreeNode node) {

        if (node == null) {
            return new Result(0, 0, 0);
        }

        Result left = longest(node.left);
        Result right = longest(node.right);
        int r = right.left + 1;
        int l = left.right + 1;
        int max = Math.max(Math.max(Math.max(r, l), left.max), right.max);
        return new Result(l, r, max);
    }

    private static class Result {

        public Result(int left, int right, int max) {
            this.left = left;
            this.right = right;
            this.max = max;
        }

        public int left;

        public int right;

        public int max;
    }
}
