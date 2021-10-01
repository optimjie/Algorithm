package com.leetcode.DailyChallenge._2021_10;

import com.leetcode.DailyChallenge._2021_9._22_725分隔链表;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _01_1436旅行终点站 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> v : paths) {
            String a = v.get(0), b = v.get(1);
            map.put(a, b);
        }
        String b = paths.get(0).get(1);
        while (true) {
            if (map.containsKey(b)) {
                b = map.get(b);
            } else {
                return b;
            }
        }
    }
}
