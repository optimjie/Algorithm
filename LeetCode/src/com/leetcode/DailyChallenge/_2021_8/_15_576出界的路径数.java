package com.leetcode.DailyChallenge._2021_8;

public class _15_576出界的路径数 {
    /**
     * @author: 李元杰
     * @params: [n, m, maxMove, startRow, startColumn]
     * @description: TODO
     * @date: 2021-08-16 16:05
     * @return: int
     */
    public int findPaths(int n, int m, int N, int stR, int stC) {
        if (N == 0) return 0;
        int mod = (int)1e9 + 7;
        int[][][] f = new int[n][m][N + 1];
        for (int i = 0; i < n; i++) {
            f[i][0][1]++;
            f[i][m - 1][1]++;
        }
        for (int j = 0; j < m; j++) {
            f[0][j][1]++;
            f[n - 1][j][1]++;
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int u = 0; u < 4; u++) {
                        int xx = i + dx[u], yy = j + dy[u];
                        if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                        f[i][j][k] = (f[i][j][k] + f[xx][yy][k - 1]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = (res + f[stR][stC][i]) % mod;
        }
        return res;
    }
}
