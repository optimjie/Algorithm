package com.leetcode.category.HashTable._169多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = map.getOrDefault(nums[i], i);
            map.put(nums[i], ++t);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) > n / 2) return nums[i];
        }
        return 0;
    }
}
