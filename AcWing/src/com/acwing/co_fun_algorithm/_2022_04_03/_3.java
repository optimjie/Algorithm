package com.acwing.co_fun_algorithm._2022_04_03;

import java.io.*;

public class _3 {

    static int V, n;
    static int[] v = new int[40];
    static int[] f = new int[20010];  // 从前i个物品里面选，体积不超过j的最大值

    public static void main(String[] args) throws IOException {

        V = nextInt(); n = nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= 1; j--) {
                if (v[i] <= j) {
                    f[j] = Math.max(f[j], f[j - v[i]] + v[i]);
                }
            }
        }

        out.println(V - f[V]);
        out.flush();

    }








    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /*String[] str = reader.readLine().split(" ");
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
