package com.zhy.leetcode.problem.populatingnextrightpointersineachnodeII;

import com.zhy.leetcode.problem.node.Node;

public class Application {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        Node connect = new Solution().connect(node);
        System.out.println(1);
    }
}
