package com.zhy.leetcode.problem.partitionlist;

import com.zhy.leetcode.problem.node.ListNode;

public class Application {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode partition = solution.partition(head, 4);
        System.out.println(1);
    }
}
