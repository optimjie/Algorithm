package com.leetcode.category.HashTable._160相交链表;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
    }
    public int getLength(ListNode p) {
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        int sub = Math.abs(len1 - len2);
        if (len1 > len2) {
            int t = sub;
            while (t-- > 0) {
                headA = headA.next;
            }
        } else {
            int t = sub;
            while (t-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
