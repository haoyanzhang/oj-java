package com.zhy.leetcode.problem.binarytreelevelordertraversalII;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        levelOrderBottom(root, 0, result);
        return result;
    }

    private void levelOrderBottom(TreeNode node, int deep, List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        if (deep == result.size()) {
            result.add(0, new ArrayList<>());
        }

        result.get(result.size() - deep - 1).add(node.val);

        levelOrderBottom(node.left, deep + 1, result);
        levelOrderBottom(node.right, deep + 1, result);
    }
}
