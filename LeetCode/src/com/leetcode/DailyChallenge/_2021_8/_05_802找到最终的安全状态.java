package com.leetcode.DailyChallenge._2021_8;

import java.util.*;

public class _05_802找到最终的安全状态 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] od = new int[N]; // out degree cnt
        List<List<Integer>> g = new ArrayList<>(); // 用来存入边
        for (int i = 0; i < N; i++) g.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                g.get(graph[i][j]).add(i);
                od[i]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (od[i] == 0) {
                ans.add(i);
                q.add(i);
            }
        }
        while (q.size() > 0) {
            int t = q.poll();
            for (int v : g.get(t)) {
                od[v]--;
                if (od[v] == 0) {
                    q.add(v);
                    ans.add(v);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
