package com.acwing.co_fun_algorithm._2022_04_04;


import java.io.*;
import java.util.Arrays;

public class _2 {


    static int N = 600010;
    static int n, m;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[][] cnt = new int[N][26];
    static char[] w = new char[N];
    static String s;
    static int idx = 0;

    static boolean[] st = new boolean[N];

    public static void add(int x, int y) {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static void dfs(int u) {

        if (st[u]) return;
        st[u] = true;


        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            for (int k = 0; k < 26; k++) {
                cnt[u][k] = Math.max(cnt[u][k], cnt[j][k]);
            }
        }

        cnt[u][w[u] - 'a']++;

    }


    public static void solve() throws IOException {

        n = nextInt();
        m = nextInt();
        s = next();
        for (int i = 1; i <= n; i++) w[i] = s.charAt(i - 1);

        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int x = nextInt(), y = nextInt();
            add(x, y);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                ans = Math.max(ans, cnt[i][j]);
            }
        }

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
