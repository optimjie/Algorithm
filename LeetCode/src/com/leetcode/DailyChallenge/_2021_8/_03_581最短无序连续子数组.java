package com.leetcode.DailyChallenge._2021_8;

import java.util.Arrays;
import java.util.Collections;

public class _03_581最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) a[i] = nums[i];
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < nums.length) {
            if (a[l] != nums[l]) break;
            l++;
        }
        while (r >= 0) {
            if (a[r] != nums[r]) break;
            r--;
        }
        if (l < r) return 0;
        return r - l + 1;
    }
}
