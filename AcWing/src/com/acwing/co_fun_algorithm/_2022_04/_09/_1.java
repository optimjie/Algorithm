package com.acwing.co_fun_algorithm._2022_04._09;

import java.io.*;
import java.util.*;

public class _1 {

    static int N = (int)2e5 + 10;
    static int n, m, k;
    static int[] a = new int[N];

    public static void solve() throws IOException {

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);

        str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(str[i]);

        Arrays.sort(a, 0, n);
        long ans = 0;
        int x = a[n - 1], y = a[n - 2];


        if (k >= m) ans = x * m;
        else {
            long t = 1l * x * k + y;  // 一组的和
            ans = (1l * m / (k + 1)) * t + (1l * m % (k + 1)) * x;
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
