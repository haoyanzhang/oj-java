package com.zhy.leetcode.problem.wordsearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhanghaoyan
 */

class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        Node root = buildTree(words);

        List<String> result = new ArrayList<>();

        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Node child = root.getChild(board[i][j]);
                if (child != null) {
                    find(board, i, j, child, used, result);
                }
            }
        }

        return  result;
    }

    private void find(char[][] board, int i, int j, Node node, boolean[][] used, List<String> result) {
        String value;
        if ((value = node.getValue()) != null) {
            node.setValue(null);
            result.add(value);
        }
        used[i][j] = true;
        Node next = null;
        Character character = get(board, i - 1, j);
        if (character != null && (next = node.getChild(character)) != null && !used[i - 1][j]) {
            find(board, i - 1, j, next, used, result);
        }
        character = get(board, i + 1, j);
        if (character != null && (next = node.getChild(character)) != null && !used[i + 1][j]) {
            find(board, i + 1, j, next, used, result);
        }
        character = get(board, i, j - 1);
        if (character != null && (next = node.getChild(character)) != null && !used[i][j - 1]) {
            find(board,  i, j - 1,  next, used, result);
        }
        character = get(board, i, j + 1);
        if (character != null && (next = node.getChild(character)) != null && !used[i][j + 1]) {
            find(board, i, j + 1, next, used, result);
        }
        used[i][j] = false;
    }

    private Node buildTree(String[] words) {

        Node root = new Node();

        for (String s : words) {
            char[] chars = s.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                cur = cur.ensure(aChar);
            }
            cur.setValue(s);
        }

        return root;
    }

    private static class Node {

        private Node[] next = new Node[26];

        private String value;

        private Node parent = null;

        public Node ensure(char c) {
            if (next[c - 'a'] == null) {
                next[c - 'a'] = new Node();
                next[c - 'a'].setParent(this);
            }
            return next[c - 'a'];
        }

        public Node getChild(char c) {
            return next[c - 'a'];
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    private Character get(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[i].length) {
            return board[i][j];
        }
        return null;
    }
}
