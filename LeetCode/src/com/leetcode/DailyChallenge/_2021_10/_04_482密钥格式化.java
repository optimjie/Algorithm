package com.leetcode.DailyChallenge._2021_10;

public class _04_482密钥格式化 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') {
                if (c >= 'a' && c <= 'z') sb.append((char)(c - 32));
                else sb.append(c);
            }
        }
        String str = sb.toString();
        int n = str.length();
        int t = n % k;
        boolean first = true;
        if (t != 0) {
            ans.append(str.substring(0, t));
            first = false;
        }
        for (int i = t; i < n; i += k) {
            if (first) {
                first = false;
            } else {
                ans.append('-');
            }
            ans.append(str.substring(i, i + k));
        }
        return ans.toString();

    }
}
