package com.leetcode.category.DynamicProgramming._097交错字符串;

public class Solution {

    public static void main(String[] args) {
        /**
         "aabcc"
         "dbbca"
         "aadbbcbcac"
         */
        isInterleave("aab", "a", "aaba");
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        s1 = " " + s1; s2 = " " + s2; s3 = " " + s3;
        boolean[][] f = new boolean[n + 5][m + 5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                } else if (i > 0 && j > 0) {
                    if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
                        f[i][j] = f[i - 1][j] || f[i][j - 1];
                    } else if (s1.charAt(i) == s3.charAt(i + j)) {
                        f[i][j] = f[i - 1][j];
                    } else if (s2.charAt(j) == s3.charAt(i + j)) {
                        f[i][j] = f[i][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
        return f[n][m];
    }
}
