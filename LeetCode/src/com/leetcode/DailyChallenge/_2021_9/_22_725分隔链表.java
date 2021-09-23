package com.leetcode.DailyChallenge._2021_9;

public class _22_725分隔链表 {
    public class ListNode {
        ListNode next;
    }
    public int getLength(ListNode h) {
        int len = 0;
        while (h != null) {
            len++;
            h = h.next;
        }
        return len;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {

        int len = getLength(head);

        int[] a = new int[k];
        for (int i = 0; i < k; i++) a[i] = len / k;
        int sum = len % k;
        for (int i = 0; i < sum; i++) a[i]++;

        ListNode p  = head;
        ListNode[] ans = new ListNode[k];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            int t = a[i];
            if (p == null || t == 0) break;
            ans[cnt++] = p;
            while (p != null && t-- > 0) {
                if (t == 0) {
                    ListNode q = p.next;
                    p.next = null;
                    p = q;
                } else {
                    p = p.next;
                }
            }
        }
        return ans;
    }
}
