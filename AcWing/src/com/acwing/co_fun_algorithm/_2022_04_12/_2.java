package com.acwing.co_fun_algorithm._2022_04_12;

import java.io.*;
import java.util.*;

public class _2 {

    static int N = (int)5e4 + 10;
    static int n, m;
    static int[] a = new int[N];
    static int[] b = new int[N];

    static int[] min = new int[N];  // 单调减
    static int ans = 0;

    public static void solve() throws IOException {

        n = nextInt(); m = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            if (i == 0) min[i] = a[i];
            else min[i] = Math.min(min[i - 1], a[i]);
        }
        for (int i = 0; i < m; i++) b[i] = nextInt();
        int l = 0, r = n, t = -1;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                l = 0; r = n;
            } else {
                l = 0; r = t;
                if (t == -1) break;
            }
            while (l < r) {
                int mid = l + r + 1 >> 1;  // 找第一个大的
                if (min[mid] > b[i]) l = mid;
                else r = mid - 1;
            }
            if (min[l] > b[i]) {
                ans++;
                t = l - 1;
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