package com.leetcode.problem._989数组形式的整数加法;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String s = "";
        for (int i = 0; i < num.length; i++) s += num[i];
        BigInteger b = new BigInteger(s);
        BigInteger sum =  b.add(new BigInteger(String.valueOf(k)));
        String ss = sum.toString();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ss.length(); i++) {
            list.add(Integer.valueOf("" + ss.charAt(i)));
        }
        return list;
    }
}