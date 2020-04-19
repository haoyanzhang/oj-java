package com.zhy.leetcode.contest.biweeklycontest21.maximumsumbstinbinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {
    public int maxSumBST(TreeNode root) {
        return maxSum(root).res;
    }

    public Result maxSum(TreeNode node) {
        if (node == null) {
            return new Result(true, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result leftResult = maxSum(node.left);
        Result rightResult = maxSum(node.right);
        boolean isBst = leftResult.isBst && rightResult.isBst && node.val > leftResult.max && node.val < rightResult.min;
        int res = Math.max(leftResult.res, rightResult.res);
        int cur = leftResult.cur + rightResult.cur + node.val;
        if (isBst) {
            res = Math.max(res, cur);
        }
        int min = Math.min(leftResult.min, node.val);
        int max = Math.max(rightResult.max, node.val);
        return new Result(isBst, res, cur, min, max);
    }

    private static class Result {


        public Result(boolean isBst, int res,  int cur, int min, int max) {
            this.isBst = isBst;
            this.res = res;
            this.cur = cur;
            this.min = min;
            this.max = max;
        }

        public boolean isBst;

        public int res;

        public int cur;

        public int min;

        public int max;
    }
}