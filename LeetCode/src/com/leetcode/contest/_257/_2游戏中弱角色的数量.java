package com.leetcode.contest._257;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _2游戏中弱角色的数量 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int maxv = properties[0][1];
        int cnt = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < maxv) cnt++;
            maxv = Math.max(maxv, properties[i][1]);
        }
        return cnt;
    }
}
