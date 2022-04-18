package com.leetcode.DailyChallenge._2021_10;

import java.util.List;

public class _24_638大礼包 {
    // 数据范围这么小，可以试试爆搜
    int ans = Integer.MAX_VALUE;
    int cnt = 0;
    int[] cur = null;

    int a = 0, b = 0;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 1 <= n <= 6
        cur = new int[needs.size()];
        for (int i = 0; i < needs.size(); i++) {
            cur[i] = needs.get(i);
        }
        dfs(price, special, needs);
        return ans;
    }
    public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        boolean finish = true;
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] != 0) {
                finish = false;
                break;
            }
        }
        if (finish) {
            // do something
            if (cnt < ans) {
                ans = cnt;
            }
            return;
        }
        // 选单品
        for (int i = a; i < cur.length; i++) {
            a++; 
            for (int j = 0; j < cur[i]; j++) {
                cur[i] -= j;
                cnt += j * price.get(i);
                dfs(price, special, needs);
                cnt -= j * price.get(i);
                cur[i] += j;
            }
        }
        // 选大礼包
        for (int i = b; i < special.size(); i++) {
            b++;
            for (int j = 0; ; j++) {
                boolean succ = true;
                for (int u = 0; u < cur.length; u++) {
                    if (special.get(i).get(u) * j > cur[u]) {
                        succ = false;
                    }
                }
                if (!succ) break;
                for (int u = 0; u < cur.length; u++) {
                    cur[u] -= special.get(i).get(u) * j;
                    cnt += special.get(i).get(cur.length) * j;
                }
                dfs(price, special, needs);
                for (int u = 0; u < cur.length; u++) {
                    cur[u] += special.get(i).get(u) * j;
                    cnt -= special.get(i).get(cur.length) * j;
                }
            }
        }
    }
}
