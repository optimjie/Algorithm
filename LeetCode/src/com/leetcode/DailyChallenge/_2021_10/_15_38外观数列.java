package com.leetcode.DailyChallenge._2021_10;

public class _15_38外观数列 {
    public String countAndSay(int n) {
        String[] f = new String[n];
        for (int i = 0; i < n; i++) f[i] = "";
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                f[i] = "1";
            } else {
                String num = f[i - 1];
                int len = num.length();
                for (int l = 0, r = 0; l < len; ) {
                    while (r < len && num.charAt(r) == num.charAt(l)) r++;
                    f[i] = f[i] + (r - l);
                    f[i] = f[i] + num.charAt(l);
                    l = r;
                }
            }
        }
        return f[n - 1];
    }
}
