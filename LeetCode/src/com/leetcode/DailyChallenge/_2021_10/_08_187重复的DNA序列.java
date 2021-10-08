package com.leetcode.DailyChallenge._2021_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _08_187重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> st = new HashSet<>();
        if (n <= 10) return ans;
        for (int i = 0; i < n - 9; i++) {
            String t = s.substring(i, i + 10);
            if (set.contains(t) && !st.contains(t)) {
                ans.add(t);
                st.add(t);
            } else {
                set.add(t);
            }
        }
        return ans;
    }
}
