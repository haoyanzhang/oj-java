package com.zhy.leetcode.problem.findduplicatesubtrees;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String, TreeNode> idNodeMap = new HashMap<>();
        Map<String, Integer> idNummap  = new HashMap<>();

        travel(root, idNodeMap, idNummap);
        return idNummap.entrySet().stream().filter(entry -> entry.getValue() >= 2)
                .map(entry -> idNodeMap.get(entry.getKey()))
                .collect(Collectors.toList());
    }

    private String travel(TreeNode node, Map<String, TreeNode> idNodemap, Map<String, Integer> idNummap) {
        if (node == null) {
            return "null";
        }
        String id = node.val + "[" + travel(node.left, idNodemap, idNummap) + "," + travel(node.right, idNodemap, idNummap) + "]";
        if (idNummap.containsKey(id)) {
            idNummap.put(id, idNummap.get(id) + 1);
        } else {
            idNummap.put(id, 1);
            idNodemap.put(id, node);
        }
        return id;
    }
}