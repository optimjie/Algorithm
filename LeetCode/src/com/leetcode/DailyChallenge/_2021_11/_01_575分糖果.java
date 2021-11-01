package com.leetcode.DailyChallenge._2021_11;

import java.util.HashSet;
import java.util.Set;

public class _01_575分糖果 {
    public int distributeCandies(int[] c) {
        Set<Integer> set = new HashSet<>();
        for (int v : c) {
            if (set.contains(v)) continue;
            set.add(v);
        }
        int ans = 0;
        if (set.size() > c.length / 2) ans = c.length / 2;
        else ans = set.size();
        return ans;
    }
}
