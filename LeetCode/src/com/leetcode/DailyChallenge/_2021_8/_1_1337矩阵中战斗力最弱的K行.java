package com.leetcode.DailyChallenge._2021_8;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

public class _1_1337矩阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int t = 0;
            for (int j = 0; j < mat[i].length; j++) {
                t += mat[i][j];
            }
            a.add(new int[]{i, t});
        }
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = a.get(i)[0];
        }
        return ans;
    }
}
