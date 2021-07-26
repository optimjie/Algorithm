package com.leetcode.category.HashTable._202快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> set = new HashSet<>();

    public int getSum(int n) {
        int ans = 0;
        while (n > 0) {
            int dig = n % 10;
            ans += dig * dig;
            n /= 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        while (true) {
            int t = getSum(n);
            if (set.contains(t)) return false;
            if (t == 1) return true;
            set.add(t);
            n = t;
        }
    }
}
