package com.leetcode.contest._257;

public class _1统计特殊四元组 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
