package com.acwing.co_fun_algorithm._2022_04._03;

import java.io.*;
import java.util.Arrays;

public class _2 {

    static int N = (int)1e6 + 10;
    static int T = 0;
    static int a;
    static boolean[] st = new boolean[N];
    static long[] s = new long[N];

    public static boolean check(int x) {
        while (x > 0) {
            int d = x % 10;
            if (d == 7) return true;
            x /= 10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Arrays.fill(st, true);
        for (int i = 1; i < N; i++) {
            if (i % 7 == 0) {
                st[i] = false;
            } else if (check(i)) {
                st[i] = false;
            }
        }

        for (int i = 1; i < N; i++) {
            if (st[i]) {
                s[i] = (long)i * i + s[i - 1];
            } else {
                s[i] = s[i - 1];
            }
        }

        T = nextInt();
        while (T-- > 0) {
            a = nextInt();
            out.println(s[a]);
        }
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
