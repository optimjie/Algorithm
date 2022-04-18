package com.niuke.contest.niuke_practice_97;

import java.io.*;

public class _1 {

    public static int n;
    public static String s = "Yes";
    public static int[] a = new int[110];
    public static void main(String[] args) throws IOException {

        // n = nextInt();
        // s = next();
        // out.println(n);
        // out.println(s);
        // out.flush();

        n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        // 奇数
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) continue;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % 2 == 0) continue;
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        // 偶数
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) continue;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % 2 == 1) continue;
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    s = "No";
                }
            }
        }
        out.println(s);
        out.flush();
    }









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
