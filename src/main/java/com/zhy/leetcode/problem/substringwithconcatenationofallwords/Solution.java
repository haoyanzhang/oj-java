package com.zhy.leetcode.problem.substringwithconcatenationofallwords;

import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int length = words[0].length();
        Node root = buildTree(words);
        buildAC(root);
        Node cur = root;
        String[] match = new String[s.length() - length + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (cur != root && cur.childs[c-'a'] == null) {
                cur = cur.next;
            }
            if (cur.childs[c-'a'] != null) {
                cur = cur.childs[c-'a'];
                if (cur.index == length - 1) {
                    match[i - length + 1] = cur.value;
                }
            } else {
                cur = root;
            }
        }
        Arrays.sort(words);
        for (int i = 0; i < length; i++) {
            Queue<String> queue = new LinkedList<>();
            for (int j = i; j < match.length; j += length) {
                String value = match[j];
                if (value == null) {
                    queue.clear();
                    continue;
                }
                queue.add(value);
                if (queue.size() >= words.length + 1) {
                    queue.remove();
                }
                if (queue.size() >= words.length) {
                    ArrayList<String> list = new ArrayList<>(queue);
                    list.sort(Comparator.naturalOrder());
                    boolean check = true;
                    for (int k = 0; k < list.size(); k++) {
                        if (!words[k].equals(list.get(k))) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        result.add(j - words.length * length + length);
                    }
                }
            }
        }
        return result;
    }

    private Node buildTree(String[] words) {
        Node root = new Node('-', null,  -1, null);
        for (String word : words) {
            Node cur = root;
            for (int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                Node child = cur.childs[c - 'a'];
                if (child == null) {
                    if (i == word.length() - 1) {
                        cur.childs[c - 'a'] = new Node(c, cur, i, word);
                    } else {
                        cur.childs[c - 'a'] = new Node(c, cur, i, null);
                    }
                }
                cur = cur.childs[c - 'a'];
            }
        }
        return root;
    }

    private void buildAC(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            if (remove == null) {
                return;
            }
            if(remove.index == 0 || remove.index == -1) {
                remove.next = root;
            } else {
                Node father = remove.father;
                while (father != root) {
                    Node next = father.next;
                    if (next.childs[remove.c-'a'] != null) {
                        remove.next = next.childs[remove.c-'a'];
                        break;
                    } else {
                        father = next;
                    }
                }
                if (remove.next == null) {
                    remove.next = root;
                }
            }
            for (Node child : remove.childs) {
                if (child != null) {
                    queue.add(child);
                }
            }
        }
    }

    private static class Node {

        Node(char c, Node father, int index,String value) {
            this.c = c;
            this.father = father;
            this.index = index;
            this.next = null;
            this.value = value;
        }

        char c;

        Node next;

        int index;

        String value;

        Node father;

        Node[] childs = new Node[26];
    }
}
