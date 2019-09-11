package com.zhy.leetcode.problem.balancedbinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

public class Application {

    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(3);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode41 = new TreeNode(4);
        treeNode11.right = treeNode21;
        treeNode11.left = treeNode22;
        treeNode21.right = treeNode31;
        treeNode21.left = treeNode32;
        treeNode22.right = treeNode33;
        treeNode31.left = treeNode41;
        System.out.println(new Solution().isBalanced(treeNode11));
    }
}
