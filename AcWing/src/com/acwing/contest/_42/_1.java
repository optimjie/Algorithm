package com.acwing.contest._42;

import java.io.*;

public class _1 {

    /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);*/

    // 使用这个在读数字与字符的字符串时会有问题
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    static int n, m;
    static String s;
    public static void main(String[] args) throws IOException {

        n = nextInt();
        m = nextInt();

        int a, b;
        double minv = 1000.0;
        for (int i = 0; i < n; i++) {
            a = nextInt();
            b = nextInt();
            minv = Math.min(minv, 1.0 * a / b);
        }

        out.println(String.format("%.6f", m * minv));
        out.flush();

    }
}
