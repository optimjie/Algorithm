package com.acwing.co_fun_algorithm._2022_04_08;


import java.io.*;
import java.util.Arrays;

public class _2 {



    public static void solve() throws IOException {

        int n;
        int[] a = new int[1010];
        n = nextInt();
        for (int i = 0; i < n; i++) a[i] = nextInt();
        Arrays.sort(a, 0, n);


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] >= a[i] + a[j]) r = mid - 1;
                    else l = mid;
                }
                int x = -1, y = -1;
                if (a[l] < a[i] + a[j]) y = l;
                l = j + 1;
                r = n - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (a[mid] <= a[j] - a[i]) l = mid + 1;
                    else r = mid;
                }
                if (a[l] > a[j] - a[i]) x = l;
                if (x != -1 && y != -1) {
                    ans += y - x + 1;
                }
            }
        }

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
