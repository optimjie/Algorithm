package com.leetcode.DailyChallenge._2021_10;

public class _23_492构造矩形 {
    public int[] constructRectangle(int area) {
        for (int min = (int)Math.sqrt(area); min >= 1; min--) {
            int max = area / min;
            if (min * max == area) {
                return new int[]{max, min};
            }
        }
        return null;
    }
}
