package com.zhy.leetcode.problem.mergekSortedlists;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode[] heap = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            heap[i] = lists[i];
            int t = i;
            while (t > 0 && !compare(heap[t], heap[father(t)])) {
                swap(heap, t, father(t));
                t = father(t);
            }
        }
        ListNode head = null;
        ListNode cur = null;
        while (heap[0] != null) {
            if (head == null) {
                head = cur = heap[0];
            } else {
                cur.next = heap[0];
                cur = cur.next;
            }
            heap[0] = cur.next;
            int i = 0;
            while (i < heap.length) {
                int i1 = lChild(i);
                int i2 = rChild(i);
                if (i2 >= heap.length && i1 < heap.length && compare(heap[i], heap[i1])) {
                    swap(heap, i, i1);
                    break;
                } else if (i2 < heap.length && i1 < heap.length) {
                    int min;
                    int max;
                    if (compare(heap[i1], heap[i2])) {
                        min = i2;
                        max = i1;
                    } else {
                        min = i1;
                        max = i2;
                    }
                    if (!compare(heap[min], heap[i])) {
                        swap(heap, min, i);
                        i = min;
                    } else if (!compare(heap[max], heap[i])) {
                        swap(heap, max, i);
                        i = max;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        }
        return head;
    }

    private boolean compare(ListNode l1, ListNode l2) {
        return l1 == null || (l2 != null && l1.val >= l2.val);
    }

    private int father(int i) {
        return (i - 1) >> 1;
    }

    private int lChild(int i) {
        return (i << 1) + 1;
    }

    private int rChild(int i) {
        return (i << 1) + 2;
    }

    private void swap(ListNode[] lists, int i, int j) {
        ListNode temp = lists[i];
        lists[i] = lists[j];
        lists[j] = temp;
    }
}
