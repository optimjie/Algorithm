package com.acwing.co_fun_algorithm._2022_04_13;

import java.io.*;

public class _3 {

    static int n;
    static int N = 110;
    static int[][] d = new int[N][N];
    static int inf = 0x3f3f3f3f;

    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public static void solve() throws IOException {

        n = Integer.parseInt(reader.readLine());
        for (int i = 2; i <= n; i++) {
            String[] strs = reader.readLine().split(" ");
            for (int j = 1; j < i; j++) {
                String t = strs[j - 1];
                if (!"x".equals(t)) {
                    d[i][j] = Integer.parseInt(t);
                } else {
                    d[i][j] = inf;
                }
                d[j][i] = d[i][j];
            }
        }

        floyd();

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, d[1][i]);
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
