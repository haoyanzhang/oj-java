package com.zhy.leetcode.problem.dlipbinarytreetomatchpreordertraversal;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < voyage.length; i++) {
            map.put(voyage[i], i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (flip(root, map, result)) {
            return result;
        } else {
            result.clear();
            result.add(-1);
            return result;
        }

    }

    private boolean flip(TreeNode treeNode, HashMap<Integer, Integer> map, List<Integer> result) {
        if (treeNode.left == null && treeNode.right == null) {
            return true;
        }
        int val = treeNode.val;
        Integer index = map.get(val);
        if (treeNode.left == null) {
            Integer rightIndex = map.get(treeNode.right.val);
            if (rightIndex < index) {
                return false;
            }
            return flip(treeNode.right, map, result);
        } else if (treeNode.right == null) {
            Integer leftIndex = map.get(treeNode.left.val);
            if (leftIndex < index) {
                return false;
            }
            return flip(treeNode.left, map, result);
        } else {
            Integer rightIndex = map.get(treeNode.right.val);
            Integer leftIndex = map.get(treeNode.left.val);
            if (rightIndex < index || leftIndex < index) {
                return false;
            } else if (leftIndex > rightIndex) {
                result.add(val);
            }
            return flip(treeNode.right, map, result) && flip(treeNode.left, map, result);
        }
    }
}
