package com.acwing.co_fun_algorithm._2022_04_08;


import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _3 {  // C++已过。


    static int n;
    static int[] a = new int[15];
    static int[] b = new int[15];
    static int ans = 0;

    static boolean[] st = new boolean[15];
    static int[] p = new int[15];  // 用于记录

    static int count = 0;

    public static boolean dfs(int start, int cnt, int k) {
        if (k == 0) {  // 分了count块
            boolean res = true;
            for (int i = 0; i <= count; i++) {
                int l, r;
                if (i == 0) {
                    l = 0; r = p[i];
                } else if (i == count) {
                    l = p[count - 1] + 1;
                    r = n - 1;
                } else {
                    l = p[i - 1] + 1;
                    r = p[i];
                }

                out.println(l + " " + r);
                out.flush();

                Set<Integer> st = new HashSet<>();
                for (int j = l; j <= r; j++) st.add(b[j]);
                for (int j = l; j <= r; j++) {
                    if (!st.contains(a[j])) {
                        res = false;
                        break;
                    }
                }
                if (!res) break;
            }
            return res;
        }
        for (int i = start; i < start + n - k; i++) {  // n=5 选4 分1  分2 >  分3>>
            if (!st[i]) {
                st[i] = true;
                p[cnt] = i;
                if (dfs(start + 1, cnt + 1, k - 1)) return true;
                st[i] = false;
                p[cnt] = 0;
            }
        }
        return false;
    }

    public static boolean check(int s) {  // 分成s块
        st = new boolean[15];
        p = new int[15];
        // 总共n-1个坑，选s-1个点   即[0, n-2]里面选s-1个点
        return dfs(0, 0, s - 1);

    }


    public static void solve() throws IOException {

        n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b, 0, n);
        for (int i = n; i >= 1; i--) {
            count = n - 1;
            // out.println("zz " + i);
            // out.flush();
            if (i == 1 || check(i)) {
                ans = i;
                break;
            }
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
