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
        if (head == null) return null; // 如果head为空，则直接返回null
        if (head.child == null) { // 如果head节点没有孩子的话，直接将head的后继节点扁平化的结果接到head后即可
            Node p = solve(head.next); // 获取head的后继节点扁平化的结果
            if (p == null) return head; // 若为空直接返回head即可
            head.next = p; // 接起来
            p.prev = head;
        }
        if (head.child != null) { // 如果
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
