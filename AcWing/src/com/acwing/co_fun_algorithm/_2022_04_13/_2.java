package com.acwing.co_fun_algorithm._2022_04_13;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _2 {

    static String[] str = new String[15010];
    static Set<String> st = new HashSet<>();
    static int n = 0;

    static String[] k = new String[15010];

    public static void check(String s) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String x = str[i], y = s;  // x为字典，y为目标
            // add
            if (x.length() == y.length() - 1) {
                int len = x.length();
                for (int j = 0; j <= len; j++) {
                    x = str[i];
                    if (j == len) x = x + y.charAt(y.length() - 1);
                    else{
                        char c = y.charAt(j);
                        StringBuffer sb = new StringBuffer(x);
                        sb.insert(j, c);
                        x = sb.toString();
                    }
                    if (x.equals(y)) {
                        k[cnt++] = str[i];
                        break;
                    }
                }
            }
            x = str[i];
            // remove
            if (x.length() - 1 == y.length()) {
                int len = x.length();
                for (int j = 0; j < len; j++) {
                    x = str[i];
                    StringBuffer sb = new StringBuffer(x);
                    sb.delete(j, j + 1);
                    x = sb.toString();
                    if (x.equals(y)) {
                        k[cnt++] = str[i];
                        break;
                    }
                }
            }
            x = str[i];
            // update
            if (x.length() == y.length()) {
                int len = x.length();
                for (int j = 0; j < len; j++) {
                    x = str[i];
                    StringBuffer sb = new StringBuffer(x);
                    String c = y.substring(j, j + 1);
                    sb.replace(j, j + 1, c);
                    x = sb.toString();
                    if (x.equals(y)) {
                        k[cnt++] = str[i];
                        break;
                    }
                }
            }

        }
        if (cnt == 0) {
            out.println(s + ":");
        } else {
            out.print(s + ":");
            for (int i = 0; i < cnt; i++) {
                out.print(" " + k[i]);
            }
            out.println();
        }
    }

    public static void solve() throws IOException {

        String s = "";
        while (true) {
            s = reader.readLine();
            if ("#".equals(s)) break;
            str[n++] = s;
            st.add(s);
        }

        while (true) {
            s = reader.readLine();
            if ("#".equals(s)) break;
            if (st.contains(s)) {
                out.println(s + " is correct");
            } else {
                check(s);
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
