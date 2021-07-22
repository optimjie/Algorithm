package com.leetcode.category.HashTable._141环形链表2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public class ListNode {
        ListNode next;
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
