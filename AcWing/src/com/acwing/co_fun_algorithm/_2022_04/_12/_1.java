package com.acwing.co_fun_algorithm._2022_04._12;

import java.io.*;

public class _1 {



    public static void solve() throws IOException {

        int T = nextInt();
        while (T-- > 0) {
            long a;
            a = nextLong();
            if (a == 1 || a == 2) out.println(1);
            else {
                a--;
                long l = 1, r = (int)1e5;
                while (l < r) {
                    long mid = l + r + 1 >> 1;
                    if (mid * (mid - 1) / 2 > a) r = mid - 1;
                    else l = mid;
                }
                // out.println("zz " + l);
                if (l * (l - 1) / 2 == a) {
                    out.println(1);
                } else {
                    out.println(0);
                }
            }
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
