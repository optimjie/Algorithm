package com.acwing.算法基础课._835Trie字符串统计;

import java.io.*;

public class Trie {

    public static int N = 100010;
    public static int n;
    public static String Q, x;

    public static int[][] son = new int[N][26];
    public static int[] cnt = new int[N];
    public static int idx = 0;

    public static void insert(String x) {
        int p = 0;
        for (char c : x.toCharArray()) {
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    public static int query(String x) {
        int p = 0;
        for (char c : x.toCharArray()) {
            int u = c - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int)in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();Q = in.sval;
            in.nextToken();x = in.sval;
            if (Q.equals("I")) {
                insert(x);
            } else {
                System.out.println(query(x));
            }
        }
    }
}
