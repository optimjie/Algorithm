package com.acwing.co_fun_algorithm._2022_04_10;

import java.io.*;

public class _1 {



    public static void solve() throws IOException {

        int m, n;
        m = nextInt(); n = nextInt();

        int[][] f = new int[m + 10][n + 10];

        int mod = (int)1e9 + 7;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) f[i][j] = 1;
                else {
                    f[i][j] = ((f[i - 1][j - 1] + f[i][j - 1]) % mod + f[i - 1][j]) % mod;
                }
            }
        }

        out.println(f[m][n]);
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
