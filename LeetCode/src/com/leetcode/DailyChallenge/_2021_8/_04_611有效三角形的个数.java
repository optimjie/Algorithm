package com.leetcode.DailyChallenge._2021_8;

public class _04_611有效三角形的个数 {

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{0, 0}));
    }

    public static int triangleNumber(int[] nums) {
        int ans = 0;
        int[][] a = new int[1010][2];
        int[] s = new int[1010];
        for (int i = 1; i < 1010; i++) a[i][0] = i;
        for (int v : nums) if (v != 0) a[v][1]++;
        // 初始化前缀和
        for (int i = 1; i < 1010; i++) s[i] = s[i - 1] + a[i][1];
        // 计算三条边均相等的个数
        for (int i = 1; i < 1010; i++) {
            int t = a[i][1];
            if (t >= 3) ans += (t * (t - 1) * (t - 2)) / 6;
        }
        // 计算两条边相等的个数
        for (int i = 1; i < 1010; i++) {
            int t = a[i][1];
            if (t < 2) continue;
            ans += t * (t - 1) / 2 * (s[Math.min(1005, 2 * i - 1)] - t);
        }
        // 计算三条边均不等的个数
        for (int i = 1; i < 1010; i++) {
            if (a[i][1] == 0) continue;
            for (int j = i + 1; j < 1010; j++) {
                if (a[j][1] == 0) continue;
                ans += a[i][1] * a[j][1] * (s[Math.min(1005, i + j - 1)] - s[j]);
            }
        }
        return ans;
    }
}
