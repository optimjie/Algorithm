package com.acwing.co_fun_algorithm._2022_04._14;

import java.io.*;
import java.math.*;
import java.util.*;

public class _2 {
    static long T, n;
    public static String get(long n) {
        long cnt = 1l, sum = 1l;
        while (sum < n) {
            cnt++;
            sum = 2 * sum + 1;
        }
        long mid = (sum + 1) / 2;
        return "";
    }
    public static void solve() throws IOException {
        T = nextLong();
        while (T-- > 0) {
            n = nextLong();
            out.println(get(n));
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