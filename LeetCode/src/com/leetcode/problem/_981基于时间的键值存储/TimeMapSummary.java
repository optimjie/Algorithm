package com.leetcode.problem._981基于时间的键值存储;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMapSummary {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);
        map.put(1, list);
        for (int v : map.get(1)) {
            System.out.print(v + " ");
        }
        System.out.println();
        List<Integer> l = map.get(1);
        l.add(6);
        for (int v : map.get(1)) {
            System.out.print(v + " ");
        }
    }

    Map<String, List<Pair>> map;
    public TimeMapSummary() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        Pair target = new Pair(timestamp, String.valueOf((char)127));
        int idx = BinarySearch(pairs, target);
        if (idx > 0) {
            return pairs.get(idx - 1).getValue();
        }
        return "";
    }

    public int BinarySearch(List<Pair> pairs, Pair target) {
        int l = 0, r = pairs.size() - 1;
        if (r == 0 || pairs.get(r).compareTo(target) <= 0) {
            return r + 1;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (pairs.get(mid).compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public class Pair implements Comparable<Pair>{
        int timestamp;
        String value;

        public int getTimestamp() {
            return timestamp;
        }

        public String getValue() {
            return value;
        }

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return this.timestamp == p.timestamp && this.value.equals(p.value);
            }
            return false;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.timestamp != o.timestamp) {
                return this.timestamp - o.timestamp;
            } else {
                return this.value.compareTo(o.value);
            }
        }
    }
}
