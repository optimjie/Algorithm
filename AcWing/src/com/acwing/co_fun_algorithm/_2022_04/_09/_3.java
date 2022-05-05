package com.acwing.co_fun_algorithm._2022_04._09;

import java.io.*;
import java.util.Arrays;

public class _3 {

    static int N = 2010;
    static int n;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int idx;

    static int[] sum = new int[N];

    public static void add(int x, int y){
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static int dfs(int u, int fa) {
        sum[u] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            sum[u] += dfs(j, u);
        }
        return sum[u];
    }

    public static void solve() throws IOException {

        Arrays.fill(h, -1);
        n = nextInt();
        for (int i = 0; i < n - 1; i++) {
            int x, y;
            x = nextInt(); y = nextInt();
            add(x, y);
            add(y, x);
        }
        dfs(1, 0);
        int ans = 0;
        for (int i = 1; i <= n; i++) ans += sum[i];
        out.println(ans);
        out.flush();

    }












    static int TT = 1;
    public static void main(String[] args) throws IOException {
        while (TT-- > 0) {
            solve();
        }
    }

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // String[] str = reader.readLine().split(" ");
    // int n = Integer.parseInt(str[0]);
    // int m = Integer.parseInt(str[1]);

    // 使用这个在读数字与字符的字符串时会有问题，这个时候直接BufferedReader
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
