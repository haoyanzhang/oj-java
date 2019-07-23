package com.zhy.leetcode.problem.recoverbinarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public void recoverTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        ldr(root, list);

        Collections.sort(list);

        recover(root, list, 0);

    }

    private void ldr(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        ldr(node.left, list);
        list.add(node.val);
        ldr(node.right, list);
    }

    private int recover(TreeNode node, List<Integer> list, int index) {
        if (node == null) {
            return 0;
        }
        int lNum = recover(node.left, list, index);
        node.val = list.get(index + lNum);
        int rNum =recover(node.right, list, index + lNum + 1);
        return lNum + rNum + 1;
    }
}
