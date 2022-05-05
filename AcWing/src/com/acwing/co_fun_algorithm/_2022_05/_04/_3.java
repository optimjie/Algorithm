package com.acwing.co_fun_algorithm._2022_05._04;
import java.io.*;
import java.math.*;
import java.util.*;

public class _3 {
    static int T, n, m;
    static int N = 510, M = 2 * 70010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] vis = new boolean[N];
    static int[] color = new int[N];
    static int idx = 0;
    static boolean ok = true;
    public static void add(int x, int y) {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }
    public static void dfs(int u, int c) {
        vis[u] = true;
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j]) {
                if (color[j] == color[u]) ok = false;
            } else {
                dfs(j, c == 1 ? 0 : 1);
            }
        }
    }
    public static void solve() throws IOException {
        T = nextInt();
        while (T-- > 0) {
            n = nextInt(); m = nextInt();
            Arrays.fill(h, -1);
            Arrays.fill(vis, false);
            Arrays.fill(e, 0);
            Arrays.fill(ne, 0);
            Arrays.fill(color, 0);
            idx = 0;
            for (int i = 0; i < m; i++) {
                int x, y;
                x = nextInt(); y = nextInt();
                add(x, y); add(y, x);
            }
            ok = true;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    dfs(i, 0);
                }
            }
            if (ok) out.println("YES");
            else out.println("NO");
        }
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