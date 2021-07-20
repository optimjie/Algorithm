package com.leetcode.problem._981基于时间的键值存储;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs =  map.getOrDefault(key, new ArrayList<Pair>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        Pair target = new Pair(timestamp, String.valueOf((char)127));
        int idx = BS(pairs, target);
        if (idx > 0) return pairs.get(idx - 1).getValue();
        return "";
    }
    public int BS(List<Pair> pairs, Pair target) {
        int l = 0, r = pairs.size() - 1;
        if (r < 0 || pairs.get(r).compareTo(target) <= 0) {
            return r + 1;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (pairs.get(mid).compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = l;
            }
        }
        return l;
    }

    public class Pair implements Comparable<Pair> {

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
                Pair p = (Pair)o;
                return this.timestamp == p.timestamp && this.value.equals(p.value);
            }
            return false;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.timestamp != p.timestamp) {
                return this.timestamp - p.timestamp;
            } else {
                return this.value.compareTo(p.value);
            }
        }
    }
}
