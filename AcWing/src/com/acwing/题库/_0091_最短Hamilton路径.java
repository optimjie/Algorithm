package com.acwing.题库;

import java.io.*;

public class _0091_最短Hamilton路径 {
    static int N = 20;
    static int[][] w = new int[N][N];
    static int[][] f = new int[1 << N][20];
    static int n;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int)in.nval;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                in.nextToken(); w[i][j] = (int)in.nval;
            }
        }
        for (int i = 0; i < 1 << n; i++) for (int j = 0; j < n; j++) f[i][j] = (int)1e8;
        f[1][0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) != 0) {
                    for (int k = 0; k < n; k++) {
                        if ((i >> k & 1) != 0) {
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        out.println(f[(1 << n) - 1][n - 1]);
        out.flush();
    }
}
