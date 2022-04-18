package com.leetcode.contest._d058;

public class _1删除字符使字符串变好 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "aa";
        makeFancyString(s);
        long end = System.currentTimeMillis();
        System.out.println("time="+(end-start)+"ms");
    }
    public static String makeFancyString(String s) {
        /*char[] t = new char[100010];
        int k = 0;
        for (int l = 0, r = 0; l < s.length(); ) {
            r = l;
            while (r < s.length() && s.charAt(r) == s.charAt(l)) r++;
            t[k++] = s.charAt(l);
            if (r - l >= 2) t[k++] = s.charAt(l);
            l = r;
        }
        char[] tt = new char[k];
        for (int i = 0; i < k; i++) tt[i] = t[i];
        return String.valueOf(tt);*/
        StringBuilder ans = new StringBuilder("");
        for (int l = 0, r = 0; l < s.length(); ) {
            r = l;
            while (r < s.length() && s.charAt(r) == s.charAt(l)) r++;
            ans.append(s.charAt(l));
            if (r - l >= 2) ans.append(s.charAt(l));
            l = r;
        }
        return ans.toString();
    }
}
