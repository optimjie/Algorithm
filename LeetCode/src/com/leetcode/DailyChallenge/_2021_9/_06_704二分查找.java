package com.leetcode.DailyChallenge._2021_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _06_704二分查找 {
    public int search(int[] nums, int target) {
        List<Integer> ll = new ArrayList<>(Arrays.asList(-1));
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}
