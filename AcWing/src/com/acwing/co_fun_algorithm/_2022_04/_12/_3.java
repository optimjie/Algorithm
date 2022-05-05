package com.acwing.co_fun_algorithm._2022_04._12;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class _3 {



    public static void solve() throws IOException {

        int n = nextInt();
        int[][] a = new int[50010][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nextInt(); a[i][1] = nextInt();
        }

        Arrays.sort(a, 0, n, (o1, o2) -> o1[0] - o2[0]);

        int end = -1;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (a[i][1] <= end) {
                ans = Math.max(ans, a[i][1] - a[i][0]);
            }
            if (a[i][0] <= end && end <= a[i][1]) {
                ans = Math.max(ans, end - a[i][0]);
            }
            end = Math.max(end, a[i][1]);
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
