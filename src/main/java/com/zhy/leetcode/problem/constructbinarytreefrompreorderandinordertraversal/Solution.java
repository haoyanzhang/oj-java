package com.zhy.leetcode.problem.constructbinarytreefrompreorderandinordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0 ,inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preorderFrom, int preorderTo
            , int[] inorder, int inorderFrom, int inorderTo) {
        if (preorderTo <= preorderFrom) {
            return null;
        }
        int value = preorder[preorderFrom];
        TreeNode treeNode = new TreeNode(value);
        for (int i = inorderFrom; i < inorderTo; i++) {
            if (inorder[i] == value) {
                int num = i - inorderFrom;
                treeNode.left = buildTree(preorder, preorderFrom + 1, preorderFrom + num + 1
                    , inorder, inorderFrom, inorderFrom + num);
                treeNode.right = buildTree(preorder, preorderFrom + num + 1, preorderTo
                        , inorder, inorderFrom + num + 1, inorderTo);
                return treeNode;
            }
        }
        return treeNode;
    }
}