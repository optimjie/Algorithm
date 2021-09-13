package com.leetcode.DailyChallenge._2021_9;

import java.util.*;

public class _13_447回旋镖的数量 {

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n <= 2) return 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                int k = mp.getOrDefault(d, 0);
                k++;
                mp.put(d, k);
            }
            for (Integer v : mp.values()) {
                cnt += v * (v - 1);
            }
        }
        return cnt;
    }
}
