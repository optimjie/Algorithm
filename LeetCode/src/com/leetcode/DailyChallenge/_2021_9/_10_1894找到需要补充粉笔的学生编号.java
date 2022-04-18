package com.leetcode.DailyChallenge._2021_9;

public class _10_1894找到需要补充粉笔的学生编号 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        for (int i = 0; ; i++) {
            if (i == n) i = 0;
            if (k < chalk[i]) return i;
            k -= chalk[i];
        }
    }
}

