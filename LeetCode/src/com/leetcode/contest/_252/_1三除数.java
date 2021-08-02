package com.leetcode.contest._252;

public class _1三除数 {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) cnt++;
        }
        if (cnt == 3) return true;
        return false;
    }
}
