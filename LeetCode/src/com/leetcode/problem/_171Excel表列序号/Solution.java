package com.leetcode.problem._171Excel表列序号;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0, k = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            ans += (columnTitle.charAt(i) - 'A' + 1) * k;
            k *= 26;
        }
        return ans;
    }
}
