package com.leetcode.DailyChallenge._2021_8;

public class _12_516最长回文子序列 {
    /**
     * @author: 李元杰
     * @params: [s]
     * @description: 经典DP问题，f[i][j]代表i~j的最大回文子序列
     *               要注意的是第一维要从大到小递推，因为计算的时候会用到i+1
     * @date: 2021-08-12 20:41
     * @return: int
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) f[i][j] = 1;
                else {
                    if (s.charAt(i) == s.charAt(j)) f[i][j] = f[i + 1][j - 1] + 2;
                    else f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                }
            }
        }
        return f[0][n - 1];
    }
}
