package com.acwing.蓝桥杯._13_A;

import java.io.*;

public class C {

    static int N = (int)2e5 + 10;
    static int n;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static Long ans = 0L;

    public static void main(String[] args) throws IOException {

        n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        for (int i = n - 1; i >= 1 ; i--) {
            if (i == n - 1) {
                s[i] = a[i];
            } else {
                s[i] = a[i] + s[i + 1];
            }
        }

        if (n == 1) {
            ans = a[0] + 0L;
        } else {
            for (int i = 0; i < n - 1; i++) {
                ans += a[i] * s[i + 1];
            }
        }

        out.println(ans);
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
