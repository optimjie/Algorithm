package com.acwing.co_fun_algorithm._2022_04._10;

import java.io.*;

public class _2 {



    public static void solve() throws IOException {

        long a, b, c, d, e, f, g, h;
        a = nextInt(); b = nextInt(); c = nextInt(); d = nextInt();
        e = nextInt(); f = nextInt(); g = nextInt(); h = nextInt();
        
        long ans = 0;
        if (a <= e && e <= c) {
            long x = Math.min(c, g) - e;
            long y = Math.max(0, Math.min(d, h) - Math.max(b, f));
            ans = x * y;
        }
        if (e <= a && a <= g) {
            long x = Math.min(c, g) - a;
            long y = Math.max(0, Math.min(d, h) - Math.max(b, f));
            ans = x * y;
        }


        ans = (c - a) * (d - b) + (g - e) * (h - f) - ans;

        out.println(ans);
        out.flush();

    }












    static int T = 1;
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
