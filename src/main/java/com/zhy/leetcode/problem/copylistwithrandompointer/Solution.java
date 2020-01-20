package com.zhy.leetcode.problem.copylistwithrandompointer;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public Node copyRandomList(Node head) {


        List<Entry>[] entries = new List[8];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new ArrayList<>();
        }
        Node cur = head;
        Node newHead = null;
        Node newCur= null;
        while (cur != null) {
            int hash = Math.abs(cur.val) % 8;
            Node to = findTo(entries[hash], cur);
            Node newNode;
            if (to == null) {
                newNode = new Node(cur.val);
                entries[hash].add(new Entry(cur, newNode));
            } else {
                newNode = to;
            }
            if (cur.random != null) {
                int randomHash = Math.abs(cur.random.val) % 8;
                Node randomTo = findTo(entries[randomHash], cur.random);
                if (randomTo == null) {
                    Node randomNode = new Node(cur.random.val);
                    newNode.random = randomNode;
                    entries[randomHash].add(new Entry(cur.random, randomNode));
                } else {
                    newNode.random = randomTo;
                }
            }
            if (newHead == null) {
                newHead = newCur = newNode;
            } else {
                newCur.next = newNode;
                newCur = newNode;
            }
            cur = cur.next;
        }
        return newHead;
    }

    private Node findTo(List<Entry> list, Node node) {
        Node to = null;
        for (Entry entry : list) {
            if (entry.from == node) {
                to = entry.to;
                break;
            }
        }
        return to;
    }

    private static class  Entry {

        public Entry(Node from, Node to) {
            this.from = from;
            this.to = to;
        }

        public Node from;

        public Node to;
    }
}
