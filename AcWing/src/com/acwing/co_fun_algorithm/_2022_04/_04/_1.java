package com.acwing.co_fun_algorithm._2022_04._04;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1 {

    static int N = 1010;
    static int T;
    static int n, h, r;
    static int[][] g = new int[N][3];  // 存xi，yi，zi
    static int[][] e = new int[N][N];  // 存相邻的球
    static int[] d = new int[N];  // 存相邻的球的个数
    static boolean[] st = new boolean[N];  // 标记是否访问过

    public static double dist(int a[], int b[]) {
        double res = Math.sqrt(((long)a[0] - b[0]) * ((long)a[0] - b[0]) + ((long)a[1] - b[1]) * ((long)a[1] - b[1]) + ((long)a[2] - b[2]) * ((long)a[2] - b[2]));
        return res;
    }

    public static void solve() throws IOException {

        T = nextInt();
        while (T-- > 0) {
            st = new boolean[N];

            n = nextInt(); h = nextInt(); r = nextInt();
            for (int i = 0; i < n; i++) {
                g[i][0] = nextInt(); g[i][1] = nextInt(); g[i][2] = nextInt();
            }
            for (int i = 0; i < n; i++) {  // 找到所有的临球
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (dist(g[i], g[j]) <= 2.0 * r) {
                        e[i][cnt++] = j;
                    }
                }
                d[i] = cnt;  // 临球的个数
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (g[i][2] <= r) {
                    q.add(i);
                }
            }
            String find = "No";
            while (q.size() > 0) {
                int t = q.poll();
                st[t] = true;
                if (g[t][2] + r >= h) {
                    find = "Yes";
                    break;
                }
                for (int i = 0; i < d[t]; i++) {
                    int j = e[t][i];
                    if (!st[j]) q.add(j);
                }
            }
            out.println(find);
            out.flush();
        }

    }












    static int TT = 1;
    public static void main(String[] args) throws IOException {
        while (TT-- > 0) {
            solve();
        }

    }

    public static Scanner cin = new Scanner(System.in);
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
