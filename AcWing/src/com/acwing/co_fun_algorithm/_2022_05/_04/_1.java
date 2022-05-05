package com.acwing.co_fun_algorithm._2022_05._04;
import java.io.*;
import java.math.*;
import java.util.*;

public class _1 {
    static int N = 100010;
    static int n, ans = 0;
    static int[] a = new int[N];
    public static void solve() throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) a[i] = nextInt();
        Arrays.sort(a, 0, n);
        for (int l = 0; l < n; ) {
            int x = a[l], r = l;
            while (r < n && a[r] == a[l] && r - l < x) r++;
            if (r == n || a[r] != a[l]) {  // r-l个一样的数 3 3
                ans += (r - l) + x - (r - l - 1);
                l = r;
            } else if (r - l == x) {
                ans += x + 1;
                l = r + 1;
            }
        }
        out.println(ans);
        out.flush();
    }

    static int TT = 1;
    public static void main(String[] args) throws IOException { while (TT-- > 0) solve(); }
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // 这个类有些问题，解决方案：https://tothefor.com/DragonOne/ff2ca664.html and https://blog.csdn.net/m0_56052256/article/details/121193785
    // 总结：读纯数字与纯大小写的字符串时用，其他的用BufferedReader即可。
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }
    public static long nextLong() throws IOException { in.nextToken(); return (long) in.nval; }
    public static String next() throws IOException { in.nextToken(); return (String) in.sval; }
    public static double nextDouble() throws IOException { in.nextToken(); return in.nval; }
}
