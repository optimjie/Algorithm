package com.acwing.co_fun_algorithm._2022_04._06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _2 {



    public static void main(String[] args) throws IOException {

        int n;
        n = nextInt();
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x, y;
            x = nextInt(); y = nextInt();
            if (y < x) {
                int t = x;
                x = y;
                y = t;
            }
            l.add(new int[]{x, y});
        }
        Collections.sort(l, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 0;
        int k = -1000;
        for (int i = 0; i < n; i++) {
            if (l.get(i)[0] >= k) {
                cnt++;
                k = l.get(i)[1];
            }
        }
        out.println(cnt);
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
