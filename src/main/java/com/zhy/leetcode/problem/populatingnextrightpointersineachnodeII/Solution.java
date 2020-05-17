package com.zhy.leetcode.problem.populatingnextrightpointersineachnodeII;

import com.zhy.leetcode.problem.node.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        Node pre = null;
        while (queue.size() > 1) {
            Node poll = queue.poll();
            if (pre != null) {
                pre.next = poll;
            }
            if (poll == null) {
                queue.offer(null);
                pre = null;
                continue;
            }
            pre = poll;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

        return root;

    }
}