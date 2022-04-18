package com.leetcode.DailyChallenge._2021_8;

public class _16_526优美的排列 {
    int n;
    int[] a = new int[20];
    boolean[] st = new boolean[20];
    /**
     * @author: 李元杰
     * @params: [n]
     * @description: 简单爆搜
     * @date: 2021-08-16 09:13
     * @return: int
     */
    public int countArrangement(int n) {
        this.n = n;
        for (int i = 1; i <= n; i++) a[i] = i;
        return dfs(1);
    }
    public int dfs(int u) {
        if (u == n + 1) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (st[i]) continue;
            if (a[i] % u == 0 || u % a[i] == 0) {
                st[i] = true;
                res += dfs(u + 1);
                st[i] = false;
            }
        }
        return res;
    }
}
