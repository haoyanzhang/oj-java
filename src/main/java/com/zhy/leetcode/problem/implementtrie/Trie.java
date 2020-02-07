package com.zhy.leetcode.problem.implementtrie;

class Trie {

    private static Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curNode = root;
        for (char c : word.toCharArray()) {
            curNode = curNode.ensurePath(c);
        }
        curNode.setValue(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curNode = root;
        for (char c : word.toCharArray()) {
            curNode = curNode.path(c);
            if (curNode == null) {
                return false;
            }
        }
        return curNode.value != null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curNode = root;
        for (char c : prefix.toCharArray()) {
            curNode = curNode.path(c);
            if (curNode == null) {
                return false;
            }
        }
        return true;
    }

    private static class Node {

        Node[] next = new Node[26];

        String value;

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Node ensurePath(char c) {
            int index = c - 'a';
            if (next[index] == null) {
                return next[index] = new Node();
            }
            return next[index];
        }

        public Node path(char c) {
            int index = c - 'a';
            return next[index];
        }
    }
}

