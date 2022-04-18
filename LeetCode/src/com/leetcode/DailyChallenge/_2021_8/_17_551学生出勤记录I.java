package com.leetcode.DailyChallenge._2021_8;

public class _17_551学生出勤记录I {
    public boolean checkRecord(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') cnt++;
        }
        if (cnt >= 2) return false;
        for (int l = 0, r = 0; l < s.length(); ) {
            while (l < s.length() && s.charAt(l) != 'L') l++;
            r = l;
            while (r < s.length() && s.charAt(r) == 'L') r++;
            if (r - l >= 3) return false;
            l = r;
        }
        return true;
    }
}
