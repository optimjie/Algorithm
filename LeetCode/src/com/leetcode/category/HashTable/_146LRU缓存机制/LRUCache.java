package com.leetcode.category.HashTable._146LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

public class LRUCache { // Least Recently Used

    public class DLNode { // 定义双链表结点
        int key, val;
        DLNode left, right;

        public DLNode(int _key, int _val) {
            key = _key;
            val = _val;
            left = null;
            right = null;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    int n; // 用于存储哈希表的长度
    DLNode L, R; // 双链表的左右端点
    Map<Integer, DLNode> map = new HashMap<>(); // 因为要通过key拿到结点进行双链表的操作，所以value要存DLNode

    public LRUCache(int capacity) {
        n = capacity;
        L = new DLNode(-1, -1);
        R = new DLNode(-1, -1);
        L.right = R;
        R.left = L;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLNode p = map.get(key);
        remove(p);
        insert(p);
        return p.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode p = map.get(key);
            p.setVal(value);
            remove(p);
            insert(p);
        } else {
            if (map.size() == n) {
                DLNode t = R.left;
                map.remove(t.getKey());
                remove(t);
            }
            DLNode t = new DLNode(key, value);
            map.put(key, t);
            insert(t);
        }
    }

    public void remove(DLNode p) {
        p.left.right = p.right;
        p.right.left = p.left;
    }

    public void insert(DLNode p) {
        p.right = L.right;
        p.left = L;
        L.right.left = p;
        L.right = p;
    }
}
