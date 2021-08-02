package com.leetcode.contest._252;

public class _3收集足够苹果的最小花园周长 {
    public long minimumPerimeter(long neededApples) {
        if (neededApples <= 12) return 8;
        long sum = 12;
        long i;
        for (i = 2; sum < neededApples; i++) {
            sum += 12 * i * i; // 化简之后
        }
        return 8 * (i - 1);
    }
}
