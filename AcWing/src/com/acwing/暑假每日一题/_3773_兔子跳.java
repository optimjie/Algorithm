package com.acwing.暑假每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3773_兔子跳 {
    static int N = 100010;
    static int[] a = new int[N];
    static int T, n, x;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            x = Integer.parseInt(s1[1]);
            String[] s2 = reader.readLine().split(" ");
            boolean find = false;
            int maxv = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s2[i]);
                if (a[i] == x) find = true;
                maxv = Math.max(maxv, a[i]);
            }
            int res = 0;
            if (find) res = 1;
            else {
                if (maxv > x) res = 2;
                else res = (x + maxv - 1) / maxv;
            }
            System.out.println(res);
        }
    }
}
