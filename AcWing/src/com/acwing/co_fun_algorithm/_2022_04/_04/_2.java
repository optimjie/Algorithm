package com.acwing.co_fun_algorithm._2022_04._04;

import java.io.*;
import java.util.*;

public class _2 {
    static int N = (int)5e4 + 10;
    static int n, l;
    static int[] a = new int[N];
    public static void solve() throws IOException {
        n = nextInt(); l = nextInt();
        int x = -1, y = -1;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            x = Math.max(x, Math.min(l - a[i], a[i]));
            y = Math.max(y, Math.max(a[i], l - a[i]));
        }
        out.println(x + " " + y);
        out.flush();
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int[] v : flowers) {
            mp.put(v[0], 0);
            mp.put(v[1], 0);
        }
        for (int[] v : flowers) {
            int x = mp.get(v[0]);
            mp.put(v[0], x + 1);
            int y = mp.get(v[1]);
            mp.put(v[1] + 1, y - 1);
        }
        for (int v : persons) mp.put(v, 0);
        int tot = 0;
        for (int k : mp.keySet()) {
            int v = mp.get(k);
            tot += v;
            mp.put(k, tot);
        }
        int[] ans = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            ans[i] = mp.get(persons[i]);
        }
        return ans;
    }

    static int TT = 1;
    public static void main(String[] args) throws IOException { while (TT-- > 0) solve(); }
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // 这个类有些问题，解决方案：https://tothefor.com/DragonOne/ff2ca664.html and https://blog.csdn.net/m0_56052256/article/details/121193785
    // 总结读纯数字与纯大小写的字符串时用，其他的用BufferedReader即可。
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    public static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    public static String next() throws IOException { in.nextToken(); return (String) in.sval; }
    public static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
}