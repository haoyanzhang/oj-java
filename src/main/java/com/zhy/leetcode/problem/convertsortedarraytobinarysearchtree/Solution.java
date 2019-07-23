package com.zhy.leetcode.problem.convertsortedarraytobinarysearchtree;

import com.zhy.leetcode.problem.node.TreeNode;

class Solution {


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0 , nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int length = end - start;
        if (length == 0) {
            return null;
        }
        int mid = length / 2 + start;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }
}
