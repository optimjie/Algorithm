package com.leetcode.DailyChallenge._2021_10;

public class _28_869重新排序得到2的幂 {
    int cnt = 0;
    int[] a = new int[15];
    int[] b = new int[15];
    boolean[] st = new boolean[15];
    boolean ans = false;
    public boolean reorderedPowerOf2(int n) {
        int t = n;
        while (t > 0) {
            int d = t % 10;
            a[cnt++] = d;
            t /= 10;
        }
        dfs(0);
        return ans;
    }
    public void dfs(int u) {
        if (u == cnt) {
            int num = 0;
            for (int i = cnt - 1, mask = 1; i >= 0; i--) {
                num += b[i] * mask;
                mask *= 10;
            }
            while (true) {
                if (num == 1) {
                    ans = true;
                    break;
                }
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    break;
                }
            }
            return;
        }
        if (u == 0) {
            for (int i = 0; i < cnt; i++) {
                if (a[i] == 0) continue;
                if (st[i]) continue;
                b[u] = a[i];
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        } else {
            for (int i = 0; i < cnt; i++) {
                if (st[i]) continue;
                b[u] = a[i];
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }

}
