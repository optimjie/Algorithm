package com.leetcode.contest._252;

public class _4统计特殊子序列的数目 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2};
        int x = countSpecialSubsequences(a);
    }
    public static int countSpecialSubsequences(int[] nums) {
        int MOD = (int)1e9 + 7;
        int[] f = new int[3];
        for (int i = 0; i < nums.length; i++) {
            /**
             0: f[i - 1][0]
             f[i - 1][0] + 1
             1: f[i - 1][1]
             f[i - 1][1]
             f[i - 1][1] + f[i - 1][0]
             2: f[i - 1][2]
             f[i - 1][2] + f[i - 1][1]
             */
            if (nums[i] == 0) f[0] = (2 * f[0] % MOD + 1) % MOD;
            if (nums[i] == 1) f[1] = (2 * f[1] % MOD + f[0]) % MOD;
            if (nums[i] == 2) f[2] = (2 * f[2] % MOD + f[1]) % MOD;
        }
        return f[2];
    }
}
