package com.zhy.leetcode.problem.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = inorderTraversal(root.left);
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
