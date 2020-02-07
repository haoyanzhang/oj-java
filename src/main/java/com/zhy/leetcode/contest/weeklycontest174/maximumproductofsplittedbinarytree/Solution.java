package com.zhy.leetcode.contest.weeklycontest174.maximumproductofsplittedbinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

import java.math.BigDecimal;
import java.math.BigInteger;

class Solution {

    long result = 0;

    public int maxProduct(TreeNode root) {

        int sum = sum(root);
        travel(root, sum);
        return (int)(result % 1000000007);
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    private int travel(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int leftSum = travel(node.left, sum);
        int rightSum = travel(node.right, sum);
        long leftProduct = (long)leftSum * (sum - leftSum);
        long rightProduct = (long)rightSum * (sum - rightSum);

        result = Math.max(result, leftProduct);
        result = Math.max(result, rightProduct);
        return node.val + leftSum + rightSum;
    }
}