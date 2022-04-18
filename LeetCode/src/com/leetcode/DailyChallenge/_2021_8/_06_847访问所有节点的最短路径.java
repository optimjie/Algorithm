package com.leetcode.DailyChallenge._2021_8;

// Hamilton路径问题
// 前置：AcWing91, AcWing731

public class _06_847访问所有节点的最短路径 {

    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] f = new int[1 << n][n];
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int x = i, y = graph[i][j];
                w[x][y] = 1;
                w[y][x] = 1;
            }
        }
        for (int i = 0; i < 1 << n; i++) for (int j = 0; j < n; j++) f[i][j] = 1000;
        for (int i = 0; i < n; i++) f[1 << i][i] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) != 0) {
                    for (int k = 0; k < n; k++) {
                        if ((i >> k & 1) != 0 && w[k][j] == 1) {
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + 1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
        int res = 1000;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[(1 << n) - 1][i]);
        }
        return res;
    }
}
