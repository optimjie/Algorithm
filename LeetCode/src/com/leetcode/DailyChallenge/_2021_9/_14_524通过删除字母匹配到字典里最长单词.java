package com.leetcode.DailyChallenge._2021_9;

import java.util.*;

public class _14_524通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });
        for (String v : dictionary) {
            if (check(s, v)) return v;
        }
        return "";
    }
    public boolean check(String s, String t) {
        if (t.length() > s.length()) return false;
        int i, j;
        for (i = 0, j = 0; i < t.length() && j < s.length(); ) {
            while (j < s.length() && s.charAt(j) != t.charAt(i)) j++;
            if (j < s.length()) {
                i++;
                j++;
            }
        }
        return i == t.length();
    }
}
