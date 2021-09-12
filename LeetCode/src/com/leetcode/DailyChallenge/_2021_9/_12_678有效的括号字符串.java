package com.leetcode.DailyChallenge._2021_9;

public class _12_678有效的括号字符串 {
    public boolean checkValidString(String s) {
        int n = s.length();
        // f[l][r]代表字符串s中从l到r是否为有效括号
        boolean[][] f = new boolean[n + 10][n + 10];
        // 初始化l>r的情况，设为true，后面会用到
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (i > j) f[i][j] = true;
        // 枚举的时候从从长度为1开始，从1到n，因为在计算长度长的子序列时会用到长度短的结果，所以要先算长度短的
        for (int len = 1; len <= n; len++) {
            // 固定了长度以后，枚举左边界
            for (int l = 0; l < n - len + 1; l++) {
                // 确定了左边界以及长度可以直接计算右边界
                int r = l + len - 1;
                // 特判长度为1的情况
                if (len == 1) { // 长度为1时，只有是"*"才合法
                    if (s.charAt(l) == '*') f[l][r] = true;
                    else f[l][r] = false;
                } else {
                    // 长度>1时，分为两大类，一类是未被分割的，一类是分割的
                    // 这里的未分割是指这种情况："(())" 即不能分成两个合法的序列
                    // 这里的分割是指这种情况："()()" 即能分割成两个合法的序列
                    // 计算未被分割
                    if (s.charAt(l) == '*' && f[l + 1][r]) f[l][r] = true; // 最左边是"*"代表空，那么只看l+1到r就可以
                    if (s.charAt(r) == '*' && f[l][r - 1]) f[l][r] = true; // 最右边是"*"代表空，那么只看l到r-1就可以
                    f[l][r] = f[l][r] || f[l + 1][r - 1] && check(s.charAt(l), s.charAt(r)); // 第一个要或是因为，经过上面两步的计算有可能f[l][r]已经是true了，只有不是才
                                                                                             // 计算或右边，也就是检查l到r中最左和最右是否匹配，以及l+1到r-1是否合法。
                    // 计算被分割
                    if (f[l][r]) continue; // 如果未分割时已经合法了那么，也没必要再去计算已经分割的了
                    for (int k = l; k < r; k++) { // 枚举分割的点k，从l到r-1，也就是分成l到k以及k+1到r，两个子序列
                        if (k == l) f[l][r] = f[l][r] || s.charAt(l) == '*' && f[l + 1][r]; // 若左边的序列长度为1
                        else if (k == r - 1) f[l][r] = f[l][r] || s.charAt(r) == '*' && f[l][r - 1]; // 若右边的序列长度为1
                        else { // 直接看l到k和k+1到r是否都合法
                            f[l][r] = f[l][r] || f[l][k] && f[k + 1][r];
                        }
                    }
                }
            }
        }
        return f[0][n - 1]; // 返回从0到n-1
    }
    public boolean check(char a, char b) { // 检查字符a和字符b是否合法
        if (a == '(' && b == ')') return true;
        if (a == '*' && b == ')') return true;
        if (a == '(' && b == '*') return true;
        if (a == '*' && b == '*') return true;
        return false;
    }
}
