package com.leetcode.contest._251;

public class _2子字符串突变后可能得到的最大整数 {
    public String maximumNumber(String num, int[] change) {
        String ans = "";
        int k = 0;
        for (char c : num.toCharArray()) {
            int t = c - '0';
            if (t >= change[k]) {
                ans = ans + t;
            } else {
                ans = ans + change[k];
            }
            k++;
        }
        return ans;
    }
}
