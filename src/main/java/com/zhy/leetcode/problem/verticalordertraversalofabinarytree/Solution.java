package com.zhy.leetcode.problem.verticalordertraversalofabinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> leftResult = new ArrayList<>();
        List<List<Integer>> rightResult = new ArrayList<>();

        Queue<QueueNode> queue = new PriorityQueue<>(new Comparator<QueueNode>() {
            @Override
            public int compare(QueueNode o1, QueueNode o2) {
                int depthValue = o1.depth - o2.depth;
                if (depthValue != 0) {
                    return depthValue;
                }
                int indexValue = o1.index - o2.index;
                if (indexValue != 0) {
                    return indexValue;
                }
                return o1.value - o2.value;
            }
        });

        queue.offer(new QueueNode(0, 0, root.val, root));

        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            if (node.index >= 0) {
                if (node.index  >= rightResult.size()) {
                    rightResult.add(new ArrayList<>());
                }
                rightResult.get(node.index).add(node.value);
            } else {
                if (- node.index  - 1 >= leftResult.size()) {
                    leftResult.add(new ArrayList<>());
                }
                leftResult.get(- node.index  - 1).add(node.value);
            }
            if (node.treeNode.left != null) {
                queue.offer(new QueueNode(node.depth + 1, node.index - 1, node.treeNode.left.val, node.treeNode.left));
            }
            if (node.treeNode.right != null) {
                queue.offer(new QueueNode(node.depth + 1, node.index + 1, node.treeNode.right.val, node.treeNode.right));
            }

        }

        List<List<Integer>> result = new ArrayList<>(leftResult.size() + rightResult.size());

        for (int i = leftResult.size() - 1; i >= 0; i--) {
            result.add(leftResult.get(i));
        }
        result.addAll(rightResult);
        return result;
    }

    private static class QueueNode {

        public QueueNode(int depth, int index, int value,TreeNode treeNode) {
            this.depth = depth;
            this.index = index;
            this.value = value;
            this.treeNode = treeNode;
        }

        public int depth;

        public int index;

        public int value;

        public TreeNode treeNode;

    }


}
