package com.leetcode.DailyChallenge._2021_8;

public class _13_233数字1的个数 {
    /**
     * @author: 李元杰
     * @params: [n]
     * @description: 按位进行计算
     * @date: 2021-08-13 14:34
     * @return: int
     */
    public int countDigitOne(int n) {
        int ans = 0;
        int k = 0, t = n;
        while (t > 0) {
            k++;
            t /= 10;
        }
        int[] mask = new int[k + 1];
        mask[0] = 1;
        for (int i = 1; i <= k; i++) {
            mask[i] = mask[i - 1] * 10;
        }
        for (int i = 1; i <= k; i++) { // 12312
            int d = n % mask[i] / mask[i - 1];
            int l = n / mask[i], r = n % mask[i - 1];
            // System.out.println(i + " " + mask[i] + " " + num[i] + " " + d + " " + l + " " + r);
            ans += l * (int)Math.pow(10, i - 1);
            if (d == 1) {
                ans += r + 1;
            } else if (d > 1) {
                ans += (int)Math.pow(10, i - 1);
            }
        }
        return ans;
    }
}
