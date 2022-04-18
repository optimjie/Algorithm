package com.leetcode.DailyChallenge._2021_10;

public class _21_66加一 {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        int n = digits.length;
        for (int i = 0; i < n; i++) { // 特判：9...9这种情况
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            for (int i = 1; i < n + 1; i++) ans[i] = 0;
            return ans;
        }
        boolean t = true; // 表示是否进位
        for (int i = n - 1; t && i >= 0; i--) {
            if (i == n - 1 || t) {
                digits[i]++;
                if (digits[i] != 10) {
                    t = false;
                } else {
                    digits[i] = 0;
                }
            }
        }
        return digits;
    }
}
