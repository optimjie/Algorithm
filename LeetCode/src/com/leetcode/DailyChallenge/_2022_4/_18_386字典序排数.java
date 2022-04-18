package com.leetcode.DailyChallenge._2022_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_386字典序排数 {

    static List<Integer> ans = new ArrayList<>();
    static int n = 0;

    public static void dfs(int u) {

        // empty
        if (u <= n) ans.add(u);
        else return;
        for (int i = 0; i <= 9; i++) {

            dfs(Integer.parseInt((new StringBuilder()).append(u).append(i).toString()));
        }
    }


    public static List<Integer> lexicalOrder(int x) {
        n = x;
        for (int i = 1; i <= n; i++) {
            dfs(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        lexicalOrder(200);

        for (Integer v : ans) {
            System.out.print(v + " ");
        }
    }
}
