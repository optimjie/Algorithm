package com.leetcode.DailyChallenge._2021_9;


public class _24_430扁平化多级双向链表 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        Node p =  solve(head);
        Node t = p;
        while (t != null) {
            t.child = null;
            t = t.next;
        }
        return p;
    }
    public Node solve(Node head) { // 返回扁平化之后的头节点
        if (head == null) return null;
        if (head.child == null) {
            Node p = solve(head.next);
            if (p == null) return head;
            head.next = p;
            p.prev = head;
        }
        if (head.child != null) {
            Node p = solve(head.next);
            Node q = solve(head.child);
            Node t = q;
            while (t.next != null) t = t.next;
            if (q != null) {
                head.next = q;
                q.prev = head;
            }
            if (t != null && p != null) {
                t.next = p;
                p.prev = t;
            }
        }
        return head;
    }
}
