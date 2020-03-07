package com.zhy.leetcode.problem.streamofcharacters;


import java.util.ArrayList;
import java.util.List;

class StreamChecker {

    Node root;
    List<Node> queryList;

    public StreamChecker(String[] words) {
        root = new Node();
        for (String word : words) {
            Node cur = root;
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                cur = cur.ensurePath(c);
            }
            cur.value = word;
        }
        queryList = new ArrayList<>();
        queryList.add(root);
    }

    public boolean query(char letter) {
        boolean result = false;
        ArrayList<Node> nextList = new ArrayList<>();
        nextList.add(root);
        for (Node node : queryList) {
            if (node.hasPath(letter)) {
                Node nextNode = node.getPath(letter);
                nextList.add(nextNode);
                result |= nextNode.value != null;
            }
        }
        queryList = nextList;
        return result;
    }

    private static class Node {

        Node[] next = new Node[26];

        public String value;

        public Node ensurePath(char c ) {
            if (next[c - 'a'] == null) {
                next[c - 'a'] = new Node();
            }
            return next[c - 'a'];
        }

        public boolean hasPath(char c) {
            return next[c - 'a'] != null;
        }

        public Node getPath(char c) {
            return next[c - 'a'];
        }
    }
}
