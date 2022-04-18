package com.acwing.co_fun_algorithm._2022_04_05;

import java.io.*;

public class _2 {

    static int T = 1;
    static int N = 20010;

    public static void solve() throws IOException {

       int n = Integer.parseInt(reader.readLine());
       String str = reader.readLine();
       str = " " + str;
       int[] s = new int[N];
       for (int i = 1; i <= n; i++) {
           if (str.charAt(i) == '1') s[i] = s[i - 1] + 1;
           else s[i] = s[i - 1];
       }
       int ans = N;
       for (int i = 0; i <= n; i++) {
           int x = s[i];  // 前半段1的个数
           int y = n - i - (s[n] - s[i]);
           if (x + y < ans) {
               ans = x + y;
           }
       }
       out.println(ans);
       out.flush();

    }











    public static void main(String[] args) throws IOException {
        while (T-- > 0) {
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
