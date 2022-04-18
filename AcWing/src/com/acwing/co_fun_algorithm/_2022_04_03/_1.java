package com.acwing.co_fun_algorithm._2022_04_03;

import java.io.*;

public class _1 {

    static int N = 510;
    static int n;
    static int[][] a = new int[N][N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {

        n = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = a[i][j] + Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }

        out.println(f[n][n]);
        out.flush();

    }








    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /*String[] str = reader.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);*/

    // 使用这个在读数字与字符的字符串时会有问题
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
