package com.acwing.co_fun_algorithm._2022_04._07;

import java.io.*;

public class _3 {

    static long k;

    public static long check(long x) {  // 找1~x中有多少个2和5
        long cnt_2 = 0, cnt_5 = 0;
        for (long i = 2; i <= x; i *= 2) {
            cnt_2 += x / i;
        }
        for (long i = 5; i <= x; i *= 5) {
            cnt_5 += x / i;
        }

        return Math.min(cnt_5, cnt_2);
    }

    public static void solve() throws IOException {

        k = Long.parseLong(reader.readLine());

        long l = 1, r = 1l << 60;

        while (l < r) {
            long mid = (l + r) / 2;
            // 要找左端点
            if (check(mid) >= k) r = mid;
            else l = mid + 1;
        }

        out.println(l);
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
