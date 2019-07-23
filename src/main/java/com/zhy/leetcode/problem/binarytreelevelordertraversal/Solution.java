package com.zhy.leetcode.problem.binarytreelevelordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, 0, result);
        return result;
    }

    private void travel(TreeNode node, int deep, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        while (result.size() <= deep) {
            result.add(new ArrayList<>());
        }
        result.get(deep).add(node.val);
        travel(node.left, deep + 1, result);
        travel(node.right, deep + 1, result);
    }
}
