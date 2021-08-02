package com.leetcode.DailyChallenge._2021_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_743网络延迟时间 {

    int n;
    List<List<int[]>> g;
    int[] dist;
    boolean[] st;

    public void spfa(int start) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        q.add(start);
        while (q.size() > 0) {
            int t = q.poll();
            st[t] = false;
            for (int[] v : g.get(t)) {
                int node = v[0], w = v[1];
                if (dist[node] > dist[t] + w) {
                    dist[node] = dist[t] + w;
                    if (!st[node]) {
                        st[node] = true;
                        q.add(node);
                    }
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        g = new ArrayList<>();
        dist = new int[n + 3];
        st = new boolean[n + 3];
        for (int i = 0; i < n + 3; i++) g.add(new ArrayList<>());
        for (int[] v : times) {
            int a = v[0], b = v[1], c = v[2];
            g.get(a).add(new int[]{b, c});
        }
        spfa(k);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
