package com.zhy.leetcode.problem.concatenatedwords;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new ArrayList<>();

        Node root = buildTree(words);

        for (String word : words) {
            if (find(word, 0, root, root)) {
                result.add(word);
            }

        }

        return result;
    }

    private boolean find(String s, int i, Node cur, Node root) {
        if (i == s.length()) {
            return false;
        }
        Node nextNode = cur.get(s.charAt(i));
        if (nextNode == null) {
            return false;
        }
        if (nextNode.getValue() != null) {
            if (i == s.length() - 1 && !s.equals(nextNode.getValue())) {
                return true;
            }
            return find(s, i + 1, root, root) || find(s, i + 1, nextNode, root);
        }
        return find(s, i + 1, nextNode, root);
    }

    private Node buildTree(String[] words) {
        Node root = new Node();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Node cur = root;
            for (char c : charArray) {
                cur = cur.ensure(c);
            }
            cur.setValue(word);
        }
        return root;
    }

    private static class Node {

        public Node() {
        }

        public Node(String value) {
            this.value = value;
        }

        String value;

        Node[] next = new Node[26];

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node ensure(Character c) {
            if (next[c - 'a'] != null) {
                return next[c - 'a'];
            }
            return next[c - 'a'] = new Node();
        }

        public Node get(Character c) {
            return next[c - 'a'];
        }

    }
}
