package com.leetcode.DailyChallenge._2021_11;

public class _02_237删除链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) { // 4 5 1 9   1
        ListNode p = node;
        while (p.next != null) {
            p.val = p.next.val;
            if (p.next.next == null) {
                p.next = null;
                break;
            }
            p = p.next;
        }
    }
}
