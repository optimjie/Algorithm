package com.leetcode.DailyChallenge._2021_8;

public class _10_413等差数列划分 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
    /**
     * @author: 李元杰
     * @params: [nums]
     * @description: 等差数列 ====> 差分 / 不连续
     * @date: 15:12 2021-08-10
     * @return: int
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) d[i] = nums[i] - nums[i - 1];
        int ans = 0;
        for (int l = 1, r = 1; l < n; ) {
            r = l;
            while (r < n && d[r] == d[l]) r++;
            int cnt = r - l + 1;
            if (cnt < 2) continue;
            ans += (cnt - 1) * (cnt - 2) / 2;
            l = r;
        }
        return ans;
    }
    /**
     * @author: 李元杰
     * @params: [nums]
     * @description: 动态规划，f[i]表示以i为结尾的等差数列的个数，状态转移：如果三个数的不构成等差数列则f[i] = 0
     *               否则f[i]只比f[i - 1]多一个，也就是nums[i - 2], nums[i - 1], nums[i]
     * @date: 15:20 2021-08-10
     * @return: int
     */
    public static int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] f = new int[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                f[i] = f[i - 1] + 1;
                ans += f[i];
            }
        }
        return ans;
    }
}
