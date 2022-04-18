package com.leetcode.contest._251;

public class _1字符串转化后的各位数字之和 {

    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        String t = "";
        for (char c : s.toCharArray()) t = t + (c - 'a' + 1);
        s = t;
        while (k-- > 0) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                cnt += (c - '0');
            }
            s = "" + cnt;
        }
        return Integer.parseInt(s);
    }
}
