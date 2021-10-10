package com.leetcode.DailyChallenge._2021_10;

public class _10_441排列硬币 {
    public int arrangeCoins(int n) {
        long m = (long)n;
        long l = 0, r = (long)Integer.MAX_VALUE;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if ((1 + mid) * mid / 2 <= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)l;
    }
}
