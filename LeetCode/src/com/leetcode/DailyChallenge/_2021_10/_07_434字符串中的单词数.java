package com.leetcode.DailyChallenge._2021_10;

public class _07_434字符串中的单词数 {
    public int countSegments(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < n && s.charAt(i) == ' ') i++; // 去掉前面和后面的空格
        while (j >= 0 && s.charAt(j) == ' ') j--;
        if (i > j) return 0;
        int cnt = 0; // 用于记录连续空格的数量
        for (int u = i; u <= j; ) {
            if (s.charAt(u) != ' ') {
                u++;
            } else {
                cnt++;
                while (u <= j && s.charAt(u) == ' ') {
                    u++;
                }
            }
        }
        return cnt + 1;
    }
}
