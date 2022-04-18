package com.acwing.co_fun_algorithm._2022_04_05;

import com.sun.javafx.css.parser.LadderConverter;

import java.io.*;
import java.util.Arrays;

public class _1 {

    static int N = 200010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int idx = 0;
    static int n;
    static int[] hh = new int[N];
    static int height = 1;

    public static void add(int x, int y, int c) {
        e[idx] = y;
        w[idx] = c;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static void dfs(int u, int fa, int d) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            height = Math.max(height, d + 1);
            hh[d + 1] = Math.max(hh[d + 1], w[i]);
            dfs(j, u, d + 1);
        }
    }

    public static void solve() throws IOException {

        Arrays.fill(h, -1);
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            int y, c;
            y = nextInt(); c = nextInt();
            add(i, y, c);
            add(y, i, c);
        }
        hh[1] = w[0];
        dfs(1, 0, 1);

        for (int i = 1; i <= height; i++) {
            out.print(hh[i] + " ");
        }
        out.flush();
    }










    static int T = 1;
    public static void main(String[] args) throws IOException {
        while (T-- > 0) {
            solve();
        }
    }

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // String[] str = reader.readLine().split(" ");
    // int n = Integer.parseInt(str[0]);
    // int m = Integer.parseInt(str[1]);

    // 使用这个在读数字与字符的字符串时会有问题
    // 解决方案：https://tothefor.com/DragonOne/ff2ca664.html and https://blog.csdn.net/m0_56052256/article/details/121193785
    // in.ordinaryChars('0', '9') ;
    // in.wordChars('0', '9');

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
}
