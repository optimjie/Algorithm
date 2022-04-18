package com.acwing.co_fun_algorithm._2022_04_09;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class _2 {



    public static void solve() throws IOException {

        int n = nextInt();
        int[] a = new int[30010];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        int k = nextInt();

        if (k == 0) {
            int ans = 0;
            for (int l = 0; l < n;) {
                while (l < n && a[l] != 0) l++;
                int r = l;
                while (r < n && a[r] == 0) r++;
                if (r - l == 1) {
                    ans++;
                } else{
                    ans += (r - l) * (r - l + 1) / 2;
                }
                l = r;
            }
            out.println(ans);
        } else {
            Arrays.sort(a, 0, n);
            int t = 0;
            while (t < n && a[t] == 0) t++;
            int x = n - t;  // 1的个数
            int cnt = x - k + 1;
            out.println(cnt + t);
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
