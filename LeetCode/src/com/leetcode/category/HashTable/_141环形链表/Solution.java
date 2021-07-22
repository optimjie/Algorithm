package com.leetcode.category.HashTable._141环形链表;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public class ListNode {
        ListNode next;
    }
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while (p != null) {
            if (set.contains(p)) return true;
            set.add(p);
            p = p.next;
        }
        return false;
    }
}
