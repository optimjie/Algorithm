package com.acwing.co_fun_algorithm._2022_04._04;

import java.io.*;
import java.util.*;

public class _3 {
    static int N = 200010;
    static int n;
    static class Person {
        int l, r, sex, v;
        Person(int _l, int _r, int _sex, int _v) {
            l = _l; r = _r; sex = _sex; v = _v;
        }
    }
    static boolean[] st = new boolean[N];
    static Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[2] == b[2]) return a[0] - b[0];
        return a[2] - b[2];
    });
    public static void solve() throws IOException {
        n = nextInt();
        Person[] ps = new Person[n];
        for (int i = 0; i < n; i++) {
            String s = next(); int v = nextInt();
            ps[i] = new Person(i - 1, i + 1, s.equals("B") ? 1 : 0, v);
        }
        for (int i = 0; i < n - 1; i++) if (ps[i].sex != ps[i + 1].sex)
            pq.add(new int[]{i + 1, i + 2, Math.abs(ps[i].v - ps[i + 1].v)});
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        while (pq.size() > 0) {
            int[] t = pq.poll();
            int x = t[0] - 1, y = t[1] - 1;
            if (st[x] || st[y]) continue;
            int l = ps[x].l, r = ps[y].r;
            if (l >= 0) ps[l].r = r;
            if (r < n) ps[r].l = l;
            ans++;
            st[x] = st[y] = true;
            if (l >= 0 && r < n && ps[l].sex != ps[r].sex)
                pq.add(new int[]{l + 1, r + 1, Math.abs(ps[l].v - ps[r].v)});
            list.add(new int[]{x + 1, y + 1});
        }
        list.remove(0);
        out.println(ans);
        for (int[] v : list) out.println(v[0] + " " + v[1]);
        out.flush();
    }

    static int TT = 1;
    public static void main(String[] args) throws IOException { while (TT-- > 0) solve(); }
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // 这个类有些问题，解决方案：https://tothefor.com/DragonOne/ff2ca664.html and https://blog.csdn.net/m0_56052256/article/details/121193785
    // 总结：读纯数字与纯大小写的字符串时用，其他的用BufferedReader即可。
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    public static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    public static String next() throws IOException { in.nextToken(); return (String) in.sval; }
    public static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
}
