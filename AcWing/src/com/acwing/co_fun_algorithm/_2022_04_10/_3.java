package com.acwing.co_fun_algorithm._2022_04_10;

import java.io.*;

public class _3 {

    static int N = 2000010;
    static int P = 131, MOD = 19260817;
    static int[] h = new int[N];
    static int[] p = new int[N];
    static String s;


    public static int get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    public static void solve() throws IOException {

        // 131 19260817

        while ((s = reader.readLine()) != null) {
            int n = s.length();
            s = " " + s + s;
            p[0] = 1;
            for (int i = 1; i <= 2 * n; i++) {
                h[i] = h[i - 1] * P + s.charAt(i);
                p[i] = p[i - 1] * P;
            }

            String ans = "NO";
            if (n % 2 == 0) {
                for (int i = n + 1; i >= 1; i--) {
                    if (get(i, i + (n / 2) - 1) == get(i + (n / 2), i + n - 1)) {
                        ans = "YES";
                        break;
                    }
                }
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
