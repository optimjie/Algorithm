package com.leetcode.DailyChallenge._2021_8;

public class _11_446等差数列划分II子序列 {

    /**
     * @author: 李元杰
     * @params: [nums]
     * @description: 动态规划：O(n^3)，将将过
     *               状态表示：f[i][j]代表最后一个数的下标为i，倒数第二个数的下标为j的等差数列
     *               状态转移：枚举以j为结尾的序列，从0~j-1。全部加起来再加1，长度+1了，导致本来
     *               为2的也可以算一个答案
     * @date: 2021-08-11 14:26
     * @return: int
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if ((long)nums[i] - nums[j] == (long)nums[j] - nums[k]) {
                        f[i][j]++;
                        f[i][j] += f[j][k];
                    }
                }
                ans += f[i][j];
            }
        }
        return ans;
    }
}
