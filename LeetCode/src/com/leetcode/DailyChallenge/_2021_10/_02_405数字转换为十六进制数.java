package com.leetcode.DailyChallenge._2021_10;

public class _02_405数字转换为十六进制数 {

    public static void main(String[] args) {
        System.out.println(-1 >> 1);
        System.out.println(toHex(0));
    }

    public static String toHex(int num) {
        String ans = "";
        if (num == 0) ans = "0";
        while (num != 0) {
            int k = 0;
            int s = 1;
            for (int i = 0; i < 4; i++) {
                int d = num & 1;
                if (d != 0) {
                    k += s;
                }
                s *= 2;
                num = num >>> 1;
            }
            if (k <= 9) ans = ans + k;
            else {
                char c = (char) ('a' + (k - 10));
                ans = ans + c;
            }
        }
        return new StringBuffer(ans).reverse().toString();
    }
}
