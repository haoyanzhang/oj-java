package com.zhy.leetcode.problem.pathsumII;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghaoyan
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, new ArrayList<>(), sum, result);
        return result;
    }

    private void travel(TreeNode node, List<Integer> pre, int remain, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        pre.add(node.val);
        if (node.right == null && node.left == null && remain == node.val) {
            result.add(new ArrayList<>(pre));
        } else {
            travel(node.left, pre, remain - node.val, result);
            travel(node.right, pre, remain - node.val, result);
        }
        pre.remove(pre.size() - 1);
    }
}
