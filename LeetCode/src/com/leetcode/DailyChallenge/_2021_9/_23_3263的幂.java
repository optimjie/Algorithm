package com.leetcode.DailyChallenge._2021_9;

public class _23_3263的幂 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        long x = 1;
        while (x <= Integer.MAX_VALUE) {
            if (x == n) return true;
            x *= 3;
        }
        return false;
    }
}
