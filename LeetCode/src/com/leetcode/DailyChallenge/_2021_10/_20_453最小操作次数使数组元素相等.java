package com.leetcode.DailyChallenge._2021_10;

import java.util.Arrays;
import java.util.Collections;

public class _20_453最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            cnt += nums[i] - nums[0];
        }
        return cnt;
    }
}
