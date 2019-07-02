package com.zhy.leetcode.problem.binarytreezigzaglevelordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, 0, false, result);
        return result;
    }

    private void travel(TreeNode node, int deep, boolean reverse, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        while (result.size() <= deep) {
            result.add(new LinkedList<>());
        }
        if (reverse) {
            result.get(deep).add(0, node.val);
        } else {
            result.get(deep).add(node.val);
        }
        travel(node.left, deep + 1, !reverse, result);
        travel(node.right, deep + 1, !reverse, result);
    }
}
