package com.leetcode.category.DFS._207课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        int[] d = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] v : prerequisites) {
            int a = v[0], b = v[1];
            g.get(a).add(b);
            d[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (q.size() > 0) {
            int t = q.poll();
            cnt++;
            for (int v : g.get(t)) {
                d[v]--;
                if (d[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return cnt == numCourses;
    }
}
