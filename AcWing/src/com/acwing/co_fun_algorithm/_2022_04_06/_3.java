package com.acwing.co_fun_algorithm._2022_04_06;

import java.io.*;
import java.util.*;

public class _3 {



    public static void main(String[] args) throws IOException {

        int N, Q;
        N = nextInt();
        Map<String, Integer> mp = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        while (N-- > 0) {
            String s;
            s = next();
            if (cnt.containsKey(s)) {
                int x = cnt.get(s);
                x++;
                cnt.put(s, x);
            } else {
                cnt.put(s, 1);
            }
            char[] c = s.toCharArray();
            Arrays.sort(c);
            s = new String(c);
            if (mp.containsKey(s)) {
                int x = mp.get(s);
                x++;
                mp.put(s, x);
            } else {
                mp.put(s, 1);
            }
        }
        Q = nextInt();
        while (Q-- > 0) {
            String s;
            s = next();
            int k = 0;
            if (cnt.containsKey(s)) {
                k = cnt.get(s);
            }
            char[] c = s.toCharArray();
            Arrays.sort(c);
            s = new String(c);
            if (mp.containsKey(s)) {
                out.println(mp.get(s) - k);
            } else {
                out.println(0);
            }
        }
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
