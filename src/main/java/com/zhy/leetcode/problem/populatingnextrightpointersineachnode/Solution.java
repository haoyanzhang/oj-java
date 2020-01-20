package com.zhy.leetcode.problem.populatingnextrightpointersineachnode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Item> queue = new LinkedList<>();

        queue.offer(new Item(1, root));

        int curDeep = -1;
        Node last = null;

        while (!queue.isEmpty()) {
            Item poll = queue.poll();
            if (poll.deep == curDeep) {
                poll.node.next = last;
                last = poll.node;
            } else {
                curDeep = poll.deep;
                last = poll.node;
            }
            if (poll.node.right != null) {
                queue.offer(new Item(poll.deep + 1, poll.node.right));
            }
            if (poll.node.left != null) {
                queue.offer(new Item(poll.deep + 1, poll.node.left));
            }
        }

        return root;
    }

    private static class Item {

        public Item(int deep, Node node) {
            this.deep = deep;
            this.node = node;
        }

        public int deep;

        public Node node;
    }
}
