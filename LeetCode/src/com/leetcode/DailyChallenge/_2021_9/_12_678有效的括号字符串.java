package com.leetcode.DailyChallenge._2021_9;

public class _12_678有效的括号字符串 {
    String s;
    public boolean checkValidString(String s) {
        this.s = s;
        int n = s.length();
        boolean[][] f = new boolean[n + 10][n + 10]; // l r
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (i > j) f[i][j] = true;
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l < n - len + 1; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    if (s.charAt(l) == '*') f[l][r] = true;
                    else f[l][r] = false;
                } else {
                    // 未被分割
                    if (s.charAt(l) == '*' && f[l + 1][r]) f[l][r] = true;
                    if (s.charAt(r) == '*' && f[l][r - 1]) f[l][r] = true;
                    f[l][r] = f[l][r] || f[l + 1][r - 1] && check(s.charAt(l), s.charAt(r));
                    // 被分割
                    if (f[l][r]) continue;
                    for (int k = l; k < r; k++) {
                        if (k == l) f[l][r] = f[l][r] || s.charAt(l) == '*' && f[l + 1][r];
                        else if (k == r - 1) f[l][r] = f[l][r] || s.charAt(r) == '*' && f[l][r - 1];
                        else {
                            f[l][r] = f[l][r] || f[l][k] && f[k + 1][r];
                        }
                    }
                }
            }
        }
        return f[0][n - 1];
    }
    public boolean check(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '*' && b == ')') return true;
        if (a == '(' && b == '*') return true;
        if (a == '*' && b == '*') return true;
        return false;
    }
}
