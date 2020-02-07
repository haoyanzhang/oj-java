package com.zhy.leetcode.problem.sortlist;

import com.zhy.leetcode.problem.node.ListNode;

import java.util.Map;
import java.util.TreeMap;

class Solution {


    public ListNode sortList(ListNode head) {

        TreeMap<Integer, ListNode> valueNodeMap = new TreeMap<>();
        ListNode parent = new ListNode(Integer.MIN_VALUE);
        valueNodeMap.put(Integer.MIN_VALUE, parent);

        ListNode cur = head;
        while (cur != null) {
            Map.Entry<Integer, ListNode> valueNodeEntry = valueNodeMap.lowerEntry(cur.val);
            ListNode parentNode = valueNodeEntry.getValue();
            ListNode next = cur.next;
            cur.next = parentNode.next;
            parentNode.next = cur;
            if (!valueNodeMap.containsKey(cur.val)) {
                valueNodeMap.put(cur.val, cur);
            }
            cur = next;
        }
        return parent.next;

    }
}
