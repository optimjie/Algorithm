package com.acwing.co_fun_algorithm._2022_04._09;

import java.io.*;

public class _2 {

    static int N = 30010;
    static int n;
    static int[] a = new int[N];
    static int[] one = new int[N];
    static int s;

    public static void solve() throws IOException {
        n = nextInt();
        int cnt = 1;
        one[0] = -1;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            if (a[i] == 1) one[cnt++] = i;
        }
        one[cnt] = n;
        s = nextInt();
        if (s == 0) {
            int ans = 0;
            for (int l = 0; l < n; ) {
                while (l < n && a[l] == 1) l++;
                int r = l;
                while (r < n && a[r] == 0) r++;
                if (l < n) {
                    int len = r - l;
                    ans += len * (len + 1) / 2;
                }
                l = r;
            }
            out.println(ans);
        } else {
            int ans = 0;
            for (int i = 1; i <= cnt - s; i++) {
                int cnt_l = one[i] - one[i - 1] - 1;
                int cnt_r = one[i + s] - one[i + s - 1] - 1;
                ans += (cnt_l + 1) * (cnt_r + 1);
            }
            out.println(ans);
        }
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
