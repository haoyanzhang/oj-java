package com.zhy.leetcode.problem.palindromepairs;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        TreeNode root = buildTree(words);

        List<List<Integer>> result =new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            TreeNode cur = root;
            if (cur != null && cur.getIndex() != null) {
                if (chars.length != 0 && isPrefixPalindrome(chars, chars.length)) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(cur.getIndex());
                    integers.add(i);
                    result.add(integers);
                }
            }
            for (int j = chars.length - 1; j >= 0 && cur != null; j--) {
                cur = cur.find(chars[j]);
                if (cur != null && cur.getIndex() != null) {
                    if (j != 0 && isPrefixPalindrome(chars, j)) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(cur.getIndex());
                        integers.add(i);
                        result.add(integers);
                    }
                }
            }
            if (cur != null) {
                List<Integer> palindrome = cur.findPalindrome();
                for (Integer integer : palindrome) {
                    if (i != integer) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(integer);
                        integers.add(i);
                        result.add(integers);
                    }
                }
            }
        }

        return result;
    }

    private TreeNode buildTree(String[] words) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            TreeNode cur = root;
            for (char aChar : chars) {
                cur = cur.ensurePath(aChar);
            }
            cur.setIndex(i);
        }
        return root;
    }

    private static class TreeNode {

        TreeNode[] next = new TreeNode[26];

        Integer index = null;

        private TreeNode ensurePath(char c) {
            if (next[c-'a'] == null) {
                next[c-'a'] = new TreeNode();
            }
            return next[c-'a'];
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public TreeNode find(char c) {
            return next[c-'a'];
        }

        public List<Integer> findPalindrome() {
            ArrayList<Integer> result = new ArrayList<>();
            ArrayList<Character> chars = new ArrayList<>();
            dfs(this, chars, result);
            return result;
        }

        private void dfs(TreeNode node, List<Character> characters, List<Integer> result) {
            if (node.getIndex() != null && isPalindrome(characters)) {
                result.add(node.getIndex());
            }
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    characters.add((char)('a' + i));
                    dfs(node.next[i], characters, result);
                    characters.remove(characters.size() - 1);
                }
            }
        }
        private boolean isPalindrome(List<Character> list) {
            boolean result = true;
            for (int i = 0; i < list.size() / 2; i++) {
                if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                    result = false;
                }
            }
            return result;
        }
    }

    private boolean isPrefixPalindrome(char[] chars, int length) {
        boolean result = true;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                result = false;
            }
        }
        return result;
    }
}
