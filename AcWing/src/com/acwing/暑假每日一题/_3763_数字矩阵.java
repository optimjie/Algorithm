package com.acwing.暑假每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3763_数字矩阵 {
    static int[][] a = new int[110][110];
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String[] str = reader.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            int negCnt = 0;
            for (int i = 0; i < n; i++) {
                String[] str1 = reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(str1[j]);
                    if (a[i][j] < 0) negCnt++;
                }
            }
            int res = 0, minv = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res += Math.abs(a[i][j]);
                    minv = Math.min(minv, Math.abs(a[i][j]));
                }
            }
            if (negCnt % 2 == 1) res -= 2 * minv;
            System.out.println(res);
        }
    }
}
