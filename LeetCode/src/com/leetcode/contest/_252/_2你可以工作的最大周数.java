package com.leetcode.contest._252;

public class _2你可以工作的最大周数 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, maxv = 0;
        for (int v : milestones) {
            sum += v;
            maxv = Math.max(maxv, v);
        }
        sum -= maxv;
        if (sum + 1 >= maxv) return sum + maxv;
        else return 2 * sum + 1;
    }
}
