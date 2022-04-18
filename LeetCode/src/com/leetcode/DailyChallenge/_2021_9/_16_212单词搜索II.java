package com.leetcode.DailyChallenge._2021_9;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class _16_212单词搜索II {
    int n;
    int m;
    char[][] b;
    boolean[][] vis;
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    List<String> list = new ArrayList<>();
    Map<Pair<Pair<Integer, Integer>, Integer>, List<String>> mp = new HashMap<>();
    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        b = board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis = new boolean[n][m];
                vis[i][j] = true;
                List<String> l = dfs(i, j, 10, "" + b[i][j]);
                for (String v : l) {
                    list.add(v);
                }
            }
        }
        return null;
    }
    public List<String> dfs(int x, int y, int k, String s) {
        if (k == 0) return null;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx < 0 || xx >= n || yy < 0 || yy >= 0) continue;
            if (vis[xx][yy]) continue;
            List<String> l = mp.getOrDefault(new Pair<>(new Pair(xx, yy), k - 1), new ArrayList<>());
            if (l.size() == 0) { // 说明之前没有值



            }
        }
        return null;
    }
}
