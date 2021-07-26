package com.leetcode.category.HashTable._187重复的DNA序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> check = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String t = s.substring(i, i + 10);
            if (set.contains(t) && !check.contains(t)) {
                ans.add(t);
                check.add(t);
            } else {
                set.add(t);
            }
        }
        return ans;
    }
}
