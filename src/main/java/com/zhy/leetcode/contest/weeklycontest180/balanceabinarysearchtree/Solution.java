package com.zhy.leetcode.contest.weeklycontest180.balanceabinarysearchtree;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {

        List<TreeNode> ordered = new ArrayList<>();
        travel(root, ordered);
        return buildTree(ordered, 0, ordered.size() - 1);
    }

    public void travel(TreeNode treeNode, List<TreeNode> ordered) {
        if (treeNode == null) {
            return;
        }
        travel(treeNode.left, ordered);
        ordered.add(treeNode);
        travel(treeNode.right, ordered);
    }

    public TreeNode buildTree(List<TreeNode> ordered, int from, int to) {
        if (from > to) {
            return null;
        }
        int mid = (from + to) >> 1;
        TreeNode node = ordered.get(mid);
        node.left = buildTree(ordered, from, mid - 1);
        node.right = buildTree(ordered, mid + 1, to);
        return node;
    }
}
