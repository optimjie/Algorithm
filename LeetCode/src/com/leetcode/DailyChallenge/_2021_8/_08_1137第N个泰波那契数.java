package com.leetcode.DailyChallenge._2021_8;

public class _08_1137第N个泰波那契数 {
    public int tribonacci(int n) {
        if (n == 0) return 0; // 0 1 1 2 3
        if (n == 1) return 1;
        if (n == 2) return 1;
        int a = 0, b = 1, c = 1;
        int d = 0;
        for (int i = 0; i < n - 2; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
