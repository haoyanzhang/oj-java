package com.zhy.leetcode.problem.constructbinarytreefrominorderandpostordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0 ,postorder.length, index);
    }

    private TreeNode buildTree(int[] inorder, int inorderFrom, int inorderTo
            , int[] postorder, int postorderFrom, int postorderTo, Map<Integer, Integer> index) {
        if (postorderTo <= postorderFrom) {
            return null;
        }
        int value = postorder[postorderTo - 1];
        TreeNode treeNode = new TreeNode(value);
        Integer inorderIndex = index.get(value);
        int length = inorderIndex - inorderFrom;
        treeNode.left = buildTree(inorder, inorderFrom, inorderFrom + length
                , postorder, postorderFrom, postorderFrom + length, index);
        treeNode.right = buildTree(inorder, inorderFrom + length + 1, inorderTo
                , postorder, postorderFrom + length, postorderTo - 1, index);

        return treeNode;
    }
}
