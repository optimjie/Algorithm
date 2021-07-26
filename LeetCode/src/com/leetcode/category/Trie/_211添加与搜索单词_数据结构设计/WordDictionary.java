package com.leetcode.category.Trie._211添加与搜索单词_数据结构设计;

import com.leetcode.problem._981基于时间的键值存储.TimeMapSummary;

public class WordDictionary {

    public Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            int u = c - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Node p, String word, int k) {
        if (k == word.length()) return p.isEnd;
        if (word.charAt(k) != '.') {
            int u = word.charAt(k) - 'a';
            if (p.son[u] == null) return false;
            return dfs(p.son[u], word, k + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (p.son[i] != null && dfs(p.son[i], word, k + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public class Node {
        boolean isEnd;
        Node[] son;
        public Node() {
            isEnd = false;
            son = new Node[26];
            for (int i = 0; i < 26; i++) {
                son[i] = null;
            }
        }
    }
}
