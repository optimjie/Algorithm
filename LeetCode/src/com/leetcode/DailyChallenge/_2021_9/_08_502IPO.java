package com.leetcode.DailyChallenge._2021_9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _08_502IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) { // 利润 成本
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;
        while (k-- > 0) {
            while (idx < n && arr[idx][0] <= w) q.add(arr[idx++][1]);
            if (q.size() > 0) w += q.poll();
        }
        return w;
    }
}
