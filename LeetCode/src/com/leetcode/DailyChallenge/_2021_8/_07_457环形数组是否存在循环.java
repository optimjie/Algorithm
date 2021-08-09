package com.leetcode.DailyChallenge._2021_8;

public class _07_457环形数组是否存在循环 {

    public boolean circularArrayLoop(int[] nums) { // 暴力大法好
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = -1;
            if (nums[i] > 0) k = 1;
            boolean[] st = new boolean[n];
            st[i] = true;
            for (int j = (i + (nums[i] % n) + n) % n; ; j = (j + (nums[j] % n) + n) % n) {
                if (k * nums[j] < 0) break;
                if (st[j]) {
                    int len = 1;
                    for (int u = (j + (nums[j] % n) + n) % n; u != j; u = (u + (nums[u] % n) + n) % n) {
                        len++;
                    }
                    if (len > 1) return true;
                    else break;
                }
                st[j] = true;
            }
        }
        return false;
    }
}
