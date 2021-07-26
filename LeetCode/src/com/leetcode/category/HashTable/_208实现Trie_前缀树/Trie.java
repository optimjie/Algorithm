package com.leetcode.category.HashTable._208实现Trie_前缀树;

public class Trie {

    Node root;

    public class Node {
        Node[] son = new Node[26];
        boolean isEnd;
        public Node() {
            for (int i = 0; i < 26; i++) {
                son[i] = null;
            }
            isEnd = false;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return true;
    }
}
