package com.leetcode.DailyChallenge._2021_10;

import java.util.Arrays;

public class _06_414第三大的数 {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 1;
        int a = 0, b = 0, c = nums[n - 1];
        for (int i = n - 2; cnt < 3 && i >= 0; i--) {
            if (cnt == 1 && nums[i] != c) {
                b = nums[i];
                cnt++;
            }
            if (cnt == 2 && nums[i] != b) {
                a = nums[i];
                cnt++;
            }
        }
        if (cnt == 3) return a;
        else return c;
    }
}
