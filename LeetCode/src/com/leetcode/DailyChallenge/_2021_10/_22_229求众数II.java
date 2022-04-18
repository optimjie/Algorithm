package com.leetcode.DailyChallenge._2021_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _22_229求众数II {


    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0, r = 0; l < n; ) {
            r = l;
            while (r < n && nums[r] == nums[l]) r++;
            int cnt = r - l;
            if (cnt > n / 3) {
                ans.add(nums[l]);
            }
            l = r;
        }
        return ans;
    }
}
