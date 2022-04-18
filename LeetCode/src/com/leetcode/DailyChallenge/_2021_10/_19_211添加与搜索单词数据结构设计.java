package com.leetcode.DailyChallenge._2021_10;

public class _19_211添加与搜索单词数据结构设计 {

    int N = 510; // 500 50000
    int[][] son = new int[N][26];
    int idx = 0;
    boolean[] st = new boolean[25000000];

    public void WordDictionary() {

    }

    public void addWord(String word) {
        int p = 0;
        for (char c : word.toCharArray()) {
            if (c != '.') {
                int u = c - '0';
                if (son[p][u] == 0) son[p][u] = idx++;
                p = son[p][u];
            } else {
                for (;;) {

                }
            }
        }
        st[p] = true;
    }

    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - '0';
            if (son[p][u] == 0) return false;
            p = son[p][u];
        }
        return true;
    }

}
