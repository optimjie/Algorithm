package com.acwing.算法基础课._795前缀和;

import java.io.*;

public class Main {
    public static int N = 100010;
    public static int n, m;
    public static int[] a = new int[N];
    public static int[] s = new int[N];
    public static void main(String[] args) throws IOException{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int)in.nval;
        in.nextToken(); m = (int)in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken(); a[i] = (int)in.nval;
            s[i] = s[i - 1] + a[i];
        }
        int l = 0, r = 0;
        while (m-- > 0) {
            in.nextToken(); l = (int)in.nval;
            in.nextToken(); r = (int)in.nval;
            out.println(s[r] - s[l - 1]);
            out.flush();
        }
    }
}
