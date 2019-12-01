package com.zhy.leetcode.problem.binarytreepostordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghaoyan
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        travel(root, list);
        return list;
    }

    private void travel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        travel(node.left, list);
        travel(node.right, list);
        list.add(node.val);
    }
}
