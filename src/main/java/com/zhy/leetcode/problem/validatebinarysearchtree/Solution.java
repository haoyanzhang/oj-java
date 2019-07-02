package com.zhy.leetcode.problem.validatebinarysearchtree;


import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traval(root, list);
        Integer last = null;
        for (Integer integer : list) {
            if (last == null || last < integer) {
                last = integer;
            } else {
                return false;
            }
        }
        return true;
    }

    private void traval(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        traval(root.left, nums);
        nums.add(root.val);
        traval(root.right, nums);
    }
}