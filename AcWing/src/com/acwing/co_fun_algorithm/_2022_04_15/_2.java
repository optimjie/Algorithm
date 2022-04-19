package com.acwing.co_fun_algorithm._2022_04_15;

import java.io.*;

public class _2 {

    static int N = 10010;
    static int n, m;
    static int[] a = new int[N];

    public static void solve() throws IOException {

        n = nextInt(); m = nextInt();
        double t;
        for (int i = 0; i < n; i++) {
            t = nextDouble();
            a[i] = (int)(t * 100);
        }

        int l = 0, r = (int)1e7;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += a[i] / mid;
            }
            if (cnt >= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        double ans = l / 100.0;
        out.printf("%.2f", ans);
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
