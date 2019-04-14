package com.zhy.leetcode.problem.mergekSortedlists;

public class Application {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;

        solution.mergeKLists(new ListNode[]{listNode11, listNode21, listNode31});
    }
}
