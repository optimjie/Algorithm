package com.leetcode.problem._1104二叉树寻路;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0, s = 0;
        while (s < label) {
            k++;
            s = (int)Math.pow(2, k) - 1;
        }
        int x = 0, y = 0;
        for (int i = 0; i < k; i++) a.add(new ArrayList<>());
        for (int i = 0; i < k; i++) {
            int level = i + 1;
            int begin = (int)Math.pow(2, level - 1), end = (int)Math.pow(2, level) - 1;
            int sum = begin;
            if (level % 2 == 1) {
                for (int j = 0, val = begin; j < sum; j++, val++) {
                    if (val == label) {
                        x = i;
                        y = j;
                    }
                    a.get(i).add(val);
                }
            } else {
                for (int j = 0, val = end; j < sum; j++, val--) {
                    if (val == label) {
                        x = i;
                        y = j;
                    }
                    a.get(i).add(val);
                }
            }
        }
        ans.add(label);
        while (x > 0) {
            x--;
            y /= 2;
            int val = a.get(x).get(y);
            ans.add(0, val);
        }
        return ans;
    }
}
