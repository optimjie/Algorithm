package com.leetcode.category.HashTable._166分数到小数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(12, 7));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        Set<Integer> set = new HashSet<>();
        String ans = "";
        ans += numerator / denominator;
        int dig = numerator % denominator;
        String t = "";
        while (true) {
            dig *= 10;
            int n = dig / denominator;
            if (set.contains(n)) {
                t += n;
                break;
            }
            set.add(n);
            t += n;
            dig %= denominator;
        }
        System.out.println(t);
        return ans;
    }
}
