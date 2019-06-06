package com.zhy.leetcode.problem.uniquebinarysearchtreesII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n + 1);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> result = new ArrayList<>();
        if (from == to) {
            result.add(null);
            return result;
        }
        for (int i = from; i < to; i++) {
            List<TreeNode> left = generateTrees(from, i);
            List<TreeNode> right = generateTrees(i + 1, to);
            for (TreeNode leftTreeNode : left) {
                for (TreeNode rightTreeNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTreeNode;
                    treeNode.right = rightTreeNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
