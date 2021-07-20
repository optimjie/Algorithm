package com.acwing.暑假每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3768_字符串删减 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        int res = 0;
        for (int l = 0, r = 0; l < n;) {
            if (s.charAt(l) != 'x') {
                l++;
                continue;
            }
            r = l;
            int cnt = 0;
            while (r < n && s.charAt(r) == 'x') {
                cnt++;
                r++;
            }
            if (cnt >= 3) res += cnt - 2;
            l = r;
        }
        System.out.println(res);
    }
}
