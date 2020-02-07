package com.zhy.leetcode.problem.houserobberIII;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {


    public int rob(TreeNode root) {
        return travel(root).result;
    }

    public TravelResult travel(TreeNode node) {
        if (node == null) {
            return TravelResult.EMPTY;
        } else {
            TravelResult rightResult = travel(node.right);
            TravelResult leftResult = travel(node.left);
            int resultWithParent = node.val + rightResult.resultWithoutParent + leftResult.resultWithoutParent;
            int resultWithoutParent = rightResult.result + leftResult.result;
            int result = Math.max(resultWithoutParent, resultWithParent);
            return new TravelResult(resultWithoutParent, result);
        }
    }

    private static class TravelResult {

        public static TravelResult EMPTY = new TravelResult(0, 0);

        public TravelResult(int resultWithoutParent, int result) {
            this.resultWithoutParent = resultWithoutParent;
            this.result = result;
        }

        public int resultWithoutParent;

        public int result;
    }

}