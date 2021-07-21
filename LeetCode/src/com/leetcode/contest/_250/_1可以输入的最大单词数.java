package com.leetcode.contest._250;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _1可以输入的最大单词数 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            boolean find = false;
            for (int j = 0; j < s[i].length(); j++) {
                if (set.contains(s[i].charAt(j))) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                cnt++;
            }
        }
        return cnt;
    }
}
