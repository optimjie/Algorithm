package com.leetcode.DailyChallenge._2021_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _09_313超级丑数 {

    public static void main(String[] args) {
        nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }

    public static int nthSuperUglyNumber(int n, int[] primes) { //  12 [2,7,13,19]
        int[] l = new int[n];
        l[0] = 1;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        }); // 默认小根堆
        for (int i = 0; i < primes.length; i++) q.add(new int[]{0, primes[i]});
        for (int i = 1; i < n; ) {
            int[] t = q.poll();
            if (t[1] != l[i - 1]) l[i++] = t[1];
            int idx = t[0];
            q.add(new int[]{t[0] + 1, t[1] / l[idx] * l[idx + 1]});
        }
        System.out.println(l.length);
        for (int i = 0; i < n; i++) System.out.print(l[i] + " ");
        return l[n - 1];
    }
}
